/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.logic;

import com.LEGO.DTO.LEGOHouse;
import java.util.ArrayList;

/**
 *
 * @author Martin Wulff
 */
public class Cart {
    ArrayList<LEGOHouse> Cart = new ArrayList<>();
    
    public void AddToCart(LEGOHouse house){
        Cart.add(house);
    }
    
    public void RemoveItem(LEGOHouse House){
        Cart.remove(House);
    }
    
    public int getSize(){
        return Cart.size();
    }
    public LEGOHouse[] PrebForStorage(){
       return Cart.toArray( new LEGOHouse[Cart.size()]);
    }
    public int getPrice(){
        int runsum = 0;
        for (LEGOHouse hus : Cart) {
            runsum+=hus.getPrice();
        }
        return runsum;
    }
    
    
}
