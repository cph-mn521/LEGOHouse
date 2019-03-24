/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.DTO;

/**
 *  Class for representing a lego house. an array holds the amount of pieces.
 *  Array[0] = 1x2 pieces
 *  Array[1] = 2x2 pieces
 *  Array[3] = 4x2 pieces
 * 
 *  Simple solution for simple problem, and i felt like working with arrays.
 *  ¯\_(ツ)_/¯
 * 
 * @author Martin Wulff
 */
public class LEGOHouse {
    private final int len;
    private final int wid;
    private final int hei;
    private final int[] stykliste;
    private  int price = 0;
    private  int[] window;
    

    public LEGOHouse(int len, int wid,int hei,int[] stykliste) {
        this.len=len;
        this.wid=wid;
        this.hei=hei;
        this.stykliste=stykliste;
    }
        public LEGOHouse(int len, int wid,int hei,int[] stykliste,int[]window) {
        this.len=len;
        this.wid=wid;
        this.hei=hei;
        this.stykliste=stykliste;
        this.window=window;
    }
    
    
    public void setPrice(int Amount){
        price = Amount;
    }

    public int getLen() {
        return len;
    }

    public int getWid() {
        return wid;
    }

    public int getHei() {
        return hei;
    }

    public int[] getStykliste() {
        return stykliste;
    }

    public int getPrice() {
        return price;
    }

    public int[] getWindow() {
        return window;
    }

    
    
    
}
