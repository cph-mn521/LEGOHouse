<%-- 
    Document   : cart

    Author     : martin
--%>
<%@page import="com.LEGO.DTO.LEGOHouse"%>
<%@page import="com.LEGO.logic.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Styling and more-->
        <script src="./js/calcPrice.js"></script>
        <%@ include file = "/WEB-INF/jspf/header.jspf" %>
        <% Cart cart = (Cart) request.getSession().getAttribute("cart");%>
        <title>Cart</title>
    </head>

    <body>
        <%@ include file = "/WEB-INF/jspf/menu.jspf" %>
    <center>
        <table>
            <tr>
                <th>Length</th>
                <th>Height</th> 
                <th>Width</th>
                <th>price</th>
            </tr>
            <%
                for (LEGOHouse hus : cart.PrebForStorage()) {
            %>           
            <tr>
                <td> <%=hus.getLen() %></td>
                <td> <%=hus.getWid() %></td> 
                <td> <%=hus.getHei() %></td>
                <td id = "price"> <%=hus.getPrice()%> </td>
            </tr>
            <%
                }
            %>
            </table>
            <center>
                <script>calcPrice()</script>
                <p id = "TotalPrice">  <p>
                <form action="control?origin=placeorder" method="post">
                    <input type="submit" value="Place Order"/>
                </form>   
                
            </center>
        
    </center>
            
</body>
</html>
