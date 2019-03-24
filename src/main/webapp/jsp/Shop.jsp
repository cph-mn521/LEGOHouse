<%-- 
    Document   : Shop
    Created on : 20-Mar-2019, 17:29:28
    Author     : Martin Wulff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file = "/WEB-INF/jspf/header.jspf" %>
         <script src="./js/myFunction.js"></script>
        <title>Shop</title>
    </head>
    <body>
        <%@ include file = "/WEB-INF/jspf/menu.jspf" %>
    <center>
        <h2>Build your dream LEGO_TM house!</h2>
    </center>

    <center>
        <form action="control?origin=addtocart" method="post">
            <%--
            Deliberatley not coded to clearly display what im doing.
            --%>
            <input type="submit" value="Add to cart"/>    <br><br><br>
            
            
            Length of house: <input type="number" name="len" placeholder="0">
            Width of house: <input type="number" name="wid" placeholder="0">
            height of house: <input type="number" name="hei" placeholder="0"><br>

            <br>
            
            Add window:  <input type="checkbox" id="myCheck" onclick="myFunction()">
            <br>
            <p id="text" style="display:none">
               Height of Window <input type="number" name="Whei" value="0">
               Width of Window <input type="number" name="Wwid" value="0">
            </p>
            
            <p> <%= request.getAttribute("ShopMessage") != null ? request.getAttribute("ShopMessage") : ""%></p>
    </center>

</body>
</html>
