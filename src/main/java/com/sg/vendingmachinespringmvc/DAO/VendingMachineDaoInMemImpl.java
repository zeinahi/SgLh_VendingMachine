/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.DAO;

import com.sg.vendingmachinespringmvc.Model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zissah
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {
 private Map<Integer, Item> allItems = new HashMap<>();

 //Mock data that allows item buttons
    public VendingMachineDaoInMemImpl() {
 Item itemOne = new Item(1, "Snickers", new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP),9);
 Item itemTwo = new Item(2, "M&Ms", new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP),2); 
 Item itemThree = new Item(3, "Pringles", new BigDecimal(2.10).setScale(2, RoundingMode.HALF_UP),5);
 Item itemFour = new Item(4, "Reese's", new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP), 4);
 Item itemFive = new Item(5, "Pretzels", new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP), 9);
 Item itemSix = new Item(6, "Twinkies", new BigDecimal(1.95).setScale(2, RoundingMode.HALF_UP), 3);
 Item itemSeven = new Item(7, "Doritos", new BigDecimal(1.75).setScale(2, RoundingMode.HALF_UP), 11);
 Item itemEight = new Item(8, "Almond Joy", new BigDecimal(1.85).setScale(2, RoundingMode.HALF_UP),0);
 Item itemNine = new Item(9, "Trident", new BigDecimal(1.95).setScale(2, RoundingMode.HALF_UP), 6);
  
 allItems.put(1, itemOne);
 allItems.put(2, itemTwo);
 allItems.put(3, itemThree);
 allItems.put(4, itemFour);
 allItems.put(5, itemFive);
 allItems.put(6, itemSix);
 allItems.put(7, itemSeven);
 allItems.put(8, itemEight);
 allItems.put(9, itemNine);
    }

    
    @Override
    public List<Item> getAllItems() {
     return new ArrayList<Item>(allItems.values());
      
    }

    @Override
    public Item getItem(int itemId) {
     return allItems.get(itemId);
       
    }

    @Override
    public Item vendItem(Item item) {
        //Update hashmap as item is purchased
        allItems.put(item.getItemId(), item);
     return item;
    }

    @Override
    public Item updateItemInventory(Item item) {
        return allItems.put(item.getItemId(), item);
    }
    

    
}
