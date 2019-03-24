/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.logic;

import com.LEGO.DTO.LEGOHouse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Martin Wulff
 */
public class HouseLogic {

    /**
     * Calculates the price of a lego house, and updates it.
     * Should take a price list from DB as well.
     * 
     * @param House
     * @return Int
     */
    public int calcPrice(LEGOHouse House) {
        House.setPrice(0);
        return 0;

    }
    
    /**
     * Builds a lego house without a window.
     * @param len
     * @param wid
     * @param hei
     * @return LEGOHouse
     */
    public LEGOHouse buildhouse(int len, int wid, int hei) {

        // Build side 1:
        int[] stykliste = new int[3];

        stykliste[0] = (len % 4) * 2;
        stykliste[1] = ((len - 4 * stykliste[0]) % 2) * 2;
        stykliste[2] = ((len - 4 * stykliste[0] - 2 * stykliste[1])) * 2;

        wid = wid - 2;
        stykliste[0] += (wid % 4)*2;
        stykliste[1] += ((wid - 4 * stykliste[0]) % 2)*2;
        stykliste[2] += ((wid - 4 * stykliste[0] - 2 * stykliste[1]))*2;

        for (int i = 0; i < 3; i++) {
            stykliste[i] = stykliste[i] * (hei - 1);
        }
        return new LEGOHouse(len, wid, hei,stykliste);
    }
    
    /**
     * Builds house. but with a window.
     * 
     * 
     * @param len
     * @param wid
     * @param hei
     * @param window
     * @return LEGOHouse
     */
    public LEGOHouse buildhouse(int len, int wid, int hei,int[] window) {
        // Build side 1:
        int[] stykliste = new int[3];
        //Side 1
        stykliste[0] = (len % 4)*(hei-1);
        stykliste[1] = ((len - 4 * stykliste[0]) % 2)*(hei-1);
        stykliste[2] = ((len - 4 * stykliste[0] - 2 * stykliste[1]))*(hei-1);

        wid = wid - 2;
        stykliste[0] += (wid % 4);
        stykliste[1] += (wid - 4 * stykliste[0]) % 2;
        stykliste[2] += (wid - 4 * stykliste[0] - 2 * stykliste[1]);

        
        return new LEGOHouse(len, wid, hei,stykliste,window);
    }

}
