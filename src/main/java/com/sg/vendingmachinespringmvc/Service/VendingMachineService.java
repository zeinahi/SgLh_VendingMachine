/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.Service;

import com.sg.vendingmachinespringmvc.Model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author zissah
 */
public interface VendingMachineService {
    List<Item> getAllItems() throws VendingMachinePersistenceException;
    Item getItem (int itemId)throws VendingMachinePersistenceException;
    void totalMoney(String moneyValue);
    BigDecimal getTotalMoney () throws VendingMachinePersistenceException;
    void vendItem()throws VendingMachinePersistenceException,NoItemInventoryException, InsufficientFundsException;
//     void itemQuantity (Item item);
    int getSelectedId();
    int getSelectedItemId();
    void setSelectedItemId(int selectedItemId);
    void setSelectedId(int selectedId);
    String getDisplayMsg();
    void setDisplayMsg(String displayMsg);
    BigDecimal getChange();
    public int getQuarters();
    public int getDimes();
    public int getNickels();
    public int getPennies();
    
    
}
