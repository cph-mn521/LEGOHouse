/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.Data;

import com.LEGO.DBconnector.Connector;
import com.LEGO.DTO.LEGOHouse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 *
 * @author Martin Wulff
 */
public class orderMapper {

    private Connector connector = null;
    private Connection connection;
    private Statement stmt;

    public orderMapper() throws SQLException {
        this.connector = new Connector();
        this.connection = this.connector.getConnection();
        stmt = this.connection.createStatement();
    }

    public boolean createOrder(LEGOHouse[] order, String username, int price) {

        String Query = "INSERT INTO `Orders`(`User`,`price`,`dt`) VALUES"
                + "('" + username + "'," + price + "," + LocalDateTime.now().toString() + ")";
        try {
            boolean succes = stmt.execute(Query);
            if (succes) {
                Query = "select orderNumber from LEGOHouse.Orders where User ='" + username + "' order by orderNumber DESC LIMIT 0,1;";
                try {
                    ResultSet rs = stmt.executeQuery(Query);
                    rs.next();
                    
                    if(saveOrders(rs.getInt("orderNumber"), order)) return true;
                } catch (SQLException e) {
                    return false;
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public boolean saveOrders(int ordernumber, LEGOHouse[] order) {

        for (LEGOHouse hus : order) {
            try {
                stmt.execute(
                        "INSERT INTO `Shipments`(`orderNumber`,`itemprice`,`2x4Pieces`,`2x2Pieces`,`2x1Pieces`,`shipped`) VALUES ("
                        + ordernumber + ","
                        + hus.getPrice() + ","
                        + hus.getStykliste()[0] + ","
                        + hus.getStykliste()[0] + ","
                        + hus.getStykliste()[0] + ","
                        + 0 + ");");         
            }
                catch(SQLException e){
                    return false;
                    }
            
            }
        return true;
        }
    
    public int[][] getUserOrders(String Username){
        String Query = "select orderNumber,price,shipped from LEGOHouse.Orders where User ='" + Username + "' order by orderNumber DESC;";
        String Query2 = "select count(*) as C from LEGOHouse.Orders where User ='"+ Username+ "';";
        try {
            ResultSet rs = stmt.executeQuery(Query);
            ResultSet rs2 = stmt.executeQuery(Query2);
            rs.next();
            rs2.next();
            int itt = rs2.getInt("C");
            int[][]orderArray = new int[3][itt];
            
            
            
            
        } catch (SQLException e) {
            
        }
        
    }

}
