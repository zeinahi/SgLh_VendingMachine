/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.DAO;

import com.sg.vendingmachinespringmvc.Model.Item;
import java.util.List;

/**
 *
 * @author zissah
 */
public interface VendingMachineDao {
   List<Item> getAllItems();
   Item getItem(int itemId);
   Item vendItem (Item item);
   Item updateItemInventory (Item item);
}
