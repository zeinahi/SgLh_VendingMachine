<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine Spring MVC</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" >
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">
        
    </head>
    <body>
      <div class="container">
         <div class=" row">
            <h1 class="text-center" id="pageTitle">Vending Machine</h1>
            <hr/>
         </div>
      </div>
      <div class="row">
         <div id="itemBtns" class="col-md-9">
            <div class="row" id="items">
<!--                           All item buttons-->
               <c:forEach var="currentItem" items="${itemList}">
                 
                  <div class="col-md-4">
                  
                        <a  href="${pageContext.request.contextPath}/selectItem/?itemId=${currentItem.itemId}" class="btn-forSnacks">  
                           <p># ${currentItem.itemId}</p>
                           <br>
                           <p>Name: ${currentItem.itemName}</p>
                           <br>
                           <p>Price: ${currentItem.itemPrice}</p>
                           <br>
                           <p>Quantity:${currentItem.itemQuantity}</p>
                        </a>
                   
                  </div>
               </c:forEach>
            </div>
         </div>
<!--          Options/ Right side of VM-->
         <div class="col-md-3">
            <div class="row" id="totalMoneyDiv">
                <h3 class="text-center"> Total $ In </h3>
                  <form>
                   <input class="form-control" id="moneyDiv" type="BigDecimal" value="${moneyCalc}">   
                  </form>
            </div>
<!--            </div>-->
            <div class="text-center">
               <a href="${pageContext.request.contextPath}/MoneyButtonSelection?moneyValue=1.00"  class ="btn moneyBtns">Add Dollar</a>
               <a href="${pageContext.request.contextPath}/MoneyButtonSelection?moneyValue=0.25"  class ="btn moneyBtns">Add Quarter</a>
            </div>
               
            <div class="text-center">
               <a href="${pageContext.request.contextPath}/MoneyButtonSelection?moneyValue=0.10"  class ="btn moneyBtns">Add Dime</a>
               <a href="${pageContext.request.contextPath}/MoneyButtonSelection?moneyValue=0.05"  class ="btn moneyBtns">Add Nickel</a>
            </div>
            <hr>
            
            <div class="row">
                  <h3 class="text-center"> Messages</h3>
                  <form>
                  <input value="${messages}" id="messageBox"</input>
                  </form>
               </div>
                  
            <div class="text-center">
                <div class =" col-md-12">
               <form>
                  <div class="item">
                     <div class="form-inline">
                         <label for="item"> Item </label>
                        <input id="itemBox" type="text" value="${userSelection}"/>
<!--                        type hidden so can not be changed by user-->
                        <input type="hidden" id="itemPrice" /> 
                        <input type="hidden" id="itemQuantity" />
                     </div>
                  </div>
               </form>
                </div>
            </div>
                  <div class="row">
                  <div class="text-center">
                      <a href="${pageContext.request.contextPath}/vendButton" class ="btn purchaseBtn">Make Purchase</a>
                  </div>
            </div>
<!--             change display     -->
          <div class="row">
               <div class="col-md-12"
                  <h3 class="text-center">Change</h3>
               </div>
            </div>
            <hr/>
            
            <div class="text-center">
               <div class="vendingChange">
                   <input id="changeBox" type="text" value="${quarters} Quarters ${dimes} Dimes ${nickels} Nickesl ${pennies} Pennies"</input>
               </div>
               <div class="changeButton">
                  <a href="${pageContext.request.contextPath}/changeButton" class ="btn changeBtn ">Change Returned</a>
               </div>
            </div>
         </div>
      </div>
      <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
   </body>





