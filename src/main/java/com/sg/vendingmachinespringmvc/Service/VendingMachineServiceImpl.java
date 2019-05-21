/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.Service;

import com.sg.vendingmachinespringmvc.DAO.VendingMachineDao;
import com.sg.vendingmachinespringmvc.Model.Change;
import com.sg.vendingmachinespringmvc.Model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author zissah
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    String displayMsg = "";
   
    // total money inserted variable
    //total money is money user enters 
    BigDecimal totalMoney = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    Change userChange = new Change(totalMoney);
   int selectedItemId = 0;

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    public String getDisplayMsg() {
        return displayMsg;
    }

    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }
    
    
    @Override
    public int getSelectedId() {
        return selectedItemId;
    }
    

     @Override
    public void setSelectedId(int itemId) {
        this.selectedItemId = selectedItemId;
    }
    
    private VendingMachineDao dao;

    @Inject
    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(int itemId) {
        return dao.getItem(itemId);
    }

    //added moneyInserted to create what the total money will be
    public void totalMoney(String moneyValue) {
        BigDecimal moneyInserted = new BigDecimal(moneyValue).setScale(2, RoundingMode.HALF_UP);
        totalMoney = totalMoney.add(moneyInserted);
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    @Override
    public void vendItem() throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException  {
        Item item = dao.getItem(selectedItemId);
        BigDecimal itemPrice = item.getItemPrice();
        if (item.getItemQuantity() < 1) {
            displayMsg = "SOLD OUT!!!";

            //if money inserted compared to item price is <           
        } else if (totalMoney.compareTo(itemPrice) < 0) {
            BigDecimal needMoreDough = itemPrice.subtract(totalMoney);
            
            displayMsg = "Insert more money!!!";
           
        } else {
            //calculates the change needed to return to user and puts value in BigDec
            BigDecimal totalMoneyChange = totalMoney.subtract(itemPrice);
            //pass BigDec into the object so that you can set the two objects to equal 
            Change change = new Change(totalMoneyChange);
            userChange = change;
            //Call method from change dto to divide user's change into coins
          
            //reset total money inserted back to 0
            totalMoney = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
            //update inventory, subtract 1 item each time it successfully vends
            int itemUpdatedQuantity = item.getItemQuantity() - 1;
            //update newest item iventory
            item.setItemQuantity(itemUpdatedQuantity);
            dao.updateItemInventory(item);
            displayMsg = "Thank you!!!";
        }

    }

}
