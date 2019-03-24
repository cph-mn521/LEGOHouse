/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.logic;

import com.LEGO.DTO.LEGOHouse;
import com.LEGO.DTO.User;
import com.LEGO.Data.orderMapper;
import com.LEGO.Data.userMapper;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin Wulff
 */
public class Controller {

    LoginHandler LH = new LoginHandler();
    HouseLogic HL = new HouseLogic();

    public boolean loginCheck(String Username, String Password, HttpServletRequest req) {

        try {
            userMapper UM = new userMapper();
            try {
                User user = UM.getUser(Username);
                if (user.getPassword().equalsIgnoreCase(Password)) {
                    LH.login(user, req);
                    return true;
                } else {
                    req.setAttribute("loginMessage", "Failed to login, invalid password");
                    return false;
                }
            } catch (SQLException e) {
                req.setAttribute("loginMessage", "Failed to login, invalid username");
                return false;
            }

        } catch (SQLException e) {
            req.setAttribute("loginMessage", "no DB connection");
            return false;
        }

    }

    public boolean createUser(String Username, String Password, String Email, HttpServletRequest req) {
        try {
            userMapper UM = new userMapper();
            User newuser = new User(Username, Password, Email,0 );
            UM.registerUser(newuser);
            LH.login(newuser,req);
            CreateCart(req);
            return true;
        } catch (Exception e) {
            req.setAttribute("registrationMessage", "Username in use");;
            return false;
        }
    }

    public void addToCart(HttpServletRequest req) {
        if (req.getAttribute("option1") == null) {
            LEGOHouse house = HL.buildhouse(
                    Integer.parseInt(req.getParameter("len")), 
                    Integer.parseInt(req.getParameter("wid")), 
                    Integer.parseInt(req.getParameter("hei")));
            HttpSession sesh = req.getSession();
            Cart cart = (Cart) sesh.getAttribute("cart");

            req.setAttribute("ShopMessage", "Objecst added to cart. Value: ");
            cart.AddToCart(house);
            sesh.setAttribute("cart", cart);
            sesh.setAttribute("ItemsInCart", cart.getSize());
        } else {
            LEGOHouse house = HL.buildhouse(
                    Integer.parseInt(req.getParameter("len")), 
                    Integer.parseInt(req.getParameter("wid")), 
                    Integer.parseInt(req.getParameter("hei")));
            req.setAttribute("ShopMessage", "Booop ");
        }

    }

    public void CreateCart(HttpServletRequest req) {
        req.getSession().setAttribute("cart", new Cart());
        req.getSession().setAttribute("ItemsInCart", 0);
    }

    public void logOut(HttpServletRequest req) {
        LH.logout(req);
    }
    
    public boolean BuyCart(HttpServletRequest req){
        HttpSession sesh = req.getSession();
        Cart cart = (Cart)sesh.getAttribute("cart");
        User user = (User)sesh.getAttribute("user");
        cart.getSize();
        try{
            orderMapper OM = new orderMapper();
            if(OM.createOrder(cart.PrebForStorage(),user.getName(),cart.getPrice())){
                return true;
            }
            else return false;
        }
        catch(SQLException e){
            req.setAttribute("errormsg", "Order Failed.");
            return false;
        }
    }
        
    
    /*
    public void Buy(HttpServletRequest req){
        HttpSession sesh = req.getSession();
        Cart cart = (Cart)sesh.getAttribute("Cart");
        LEGOHouse[] order = cart.PrebForStorage();
        int order number = orderMapper.CreateOrder(orders);
    }
     */
}
