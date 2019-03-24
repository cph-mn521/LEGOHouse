/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.DTO;

/**
 *
 * @author Martin Wulff
 */
public class User {
    private final String name;
    private final String password;
    private final String email;
    public final boolean admin;
    
    public User(String name, String password,String Email, int admin){
        this.password = password;
        this.name = name;
        this.email = Email;
        this.admin = (admin==1);
    }

    public int isAdmin() {
        return admin?1:0;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
}
