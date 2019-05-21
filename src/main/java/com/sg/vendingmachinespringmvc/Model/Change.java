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
public class Change {
    
   Item item;
   BigDecimal quarter;
   BigDecimal dime;
   BigDecimal nickel;
   BigDecimal penny;
   BigDecimal calculateCoins;
    
   
   //Using these to store values of the change
   public Change(BigDecimal changeReturnedAsCoins) {
   BigDecimal dollarValue = new BigDecimal ("1.00");
      
    BigDecimal quarterValue = new BigDecimal ("0.25");
                
    BigDecimal dimeValue = new BigDecimal ("0.10");
                          
    BigDecimal nickelValue = new BigDecimal ("0.05");
    
    BigDecimal pennyValue = new BigDecimal("0.01");
    
    //setting global variable to change parameter to be use to return users change in coins
    this.calculateCoins = changeReturnedAsCoins;

     }

   //Used to get value of 0.25 when calculating change 
    public BigDecimal getQuarter() {
        return quarter;
    }
    
    //Used to get value of 0.10 when calculating change 
    public BigDecimal getDime() {
        return dime;
    }

    //Used to get value of 0.05 when calculating change 
    public BigDecimal getNickel() {
        return nickel;
    }

    //Used to get value of 0.01 when calculating change 
    public BigDecimal getPenny() {
        return penny;
    }

  
    
   
    
}
