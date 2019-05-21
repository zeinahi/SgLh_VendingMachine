/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.Controller;

import com.sg.vendingmachinespringmvc.Model.Item;
import com.sg.vendingmachinespringmvc.Service.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.Service.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.Service.VendingMachinePersistenceException;
import com.sg.vendingmachinespringmvc.Service.VendingMachineService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zissah
 */
//Link Dao and Service from in here
//Use Get methods in request method
//String index method where you plug model.add attribute= what happens everytime app is loaded
//Loads items buttons, shows total money back at 0, item choice returns to null, text msg to refreshs
//model holds all infor for program
//Create - POST
//Read - GET
//Update - PUT
//Delete - DELETE
@Controller
public class VendingMachineController {
   
    private VendingMachineService service;
    
    //Get service layer using beans and inject into controller
  @Inject
  //Constructor to initialize 
    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }
    //method to return back to index.jsp and load snacks
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) throws VendingMachinePersistenceException{
        //Get all items in dao through service
       List<Item>allSnackItems= service.getAllItems();
       //Put list on model
       //Model stores all variables--> allSnackItems
        model.addAttribute("itemList", allSnackItems);
        //get totalMoney value using service layer
        BigDecimal getTotalMoney = service.getTotalMoney();
        model.addAttribute("moneyCalc", getTotalMoney);
        //get userSelection value using service layer
        model.addAttribute("userSelection", service.getSelectedId());
        model.addAttribute("messages", service.getDisplayMsg());
       
        return "index";
    }
    
    @RequestMapping(value ="/MoneyButtonSelection", method = RequestMethod.GET)
    public String MoneyButtonSelection (HttpServletRequest request,Model model){
       //Goes to jsp and selects passed parameter for money value 
     String moneyValue = request.getParameter("moneyValue");
     //create new method in service
    service.totalMoney(moneyValue);
    // redirect used to return back to homepage using requestMapping
        return "redirect:/";
    }

  @RequestMapping(value="/selectItem/", method= RequestMethod.GET)
   public String selectItem (HttpServletRequest request) throws VendingMachinePersistenceException{
      //Goes to jsp and pulls into current item and then selects itemId
       String itemId= request.getParameter("itemId");
       int currentItem= Integer.parseInt(itemId);
//       service.setSelectedId(currentItem);
       service.setSelectedItemId(currentItem);
       return "redirect:/";
    } 

//    @RequestMapping(value ="/vendButton", method = RequestMethod.GET)
//    public String vendItem(HttpServletRequest request, Model model) throws NoItemInventoryException, InsufficientFundsException, VendingMachinePersistenceException {
//        List<Item>allSnackItems = service.getAllItems();
//        //selects an item after all items are displayed
//        String userSelection = request.getParameter("item");
//        //if user's choice is null
//        if(userSelection.equals("")){
//            displayMsg = "Please make selection from items displayed";     
//          return "redirect:/";
//        }
//        if (currentItem.getItemQuantity()<1){
//            displayMsg ="SOLD OUT!!! ";
//        } else {
//            if(money
//                    )// money inserted comparesTo item price is <0, calculate how much more needed
//    
//       else statment to see how much inventory is left get quan() subtract 1, return change
//    }
//        return "redirect:/";
//    }
   
  @RequestMapping(value ="/vendButton", method = RequestMethod.GET)
  public String vendItem(HttpServletRequest request, Model model) throws NoItemInventoryException, InsufficientFundsException, VendingMachinePersistenceException { 
//      service.setSelectedId(0);
      service.vendItem();
        return "redirect:/";
  }
      
  @RequestMapping (value= "/changeReturned", method = RequestMethod.GET)
  public String changeReturned(Model model){
        return null;
      
  }
    
}





