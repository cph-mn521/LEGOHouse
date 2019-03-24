/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.logic;

import com.LEGO.DTO.User;
import com.LEGO.Data.userMapper;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Martin Wulff
 */
public class LoginHandler {

    public void login(User user, HttpServletRequest req) {
        req.getSession().setAttribute("user", user);
        
        if (user.isAdmin()==1) {
            req.getSession().setAttribute("admin", true); 
                 
        } else {
            req.getSession().setAttribute("admin", false);
        }
    }

    public void logout(HttpServletRequest req) {
        req.getSession().setAttribute("user", null);
    }


}
