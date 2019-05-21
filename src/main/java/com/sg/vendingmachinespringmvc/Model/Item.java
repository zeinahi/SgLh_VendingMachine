/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.Model;

import java.math.BigDecimal;

/**
 *
 * @author zissah
 */
public class Item {
    private int itemId;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemQuantity;

    //Constructor
    public Item(int itemId , String itemName, BigDecimal itemPrice, int itemQuantity) {
       this.itemId = itemId;
       this.itemName = itemName;
       this.itemPrice = itemPrice;
       this.itemQuantity = itemQuantity;
               
    }
    
//Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    
}
