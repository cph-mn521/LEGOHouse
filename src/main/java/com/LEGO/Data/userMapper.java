/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.Data;



import com.LEGO.DBconnector.Connector;
import com.LEGO.DTO.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Martin Wulff
 */
public class userMapper {

    private Connector connector = null;
    private Connection connection;
    private Statement stmt;

    public userMapper() throws SQLException {
        this.connector = new Connector();
        this.connection = this.connector.getConnection();
        stmt = this.connection.createStatement();  
    }

    public User getUser(String Username) throws SQLException {

        String Query = "SELECT * "
                + "FROM LEGOHouse.Users"
                + " WHERE username='" + Username
                + "' ;";

        ResultSet rs = stmt.executeQuery(Query);
        rs.next(); // User er en primary key. Kun 1 resultat bør returnes.

        User user = new User(
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                (int)rs.getByte("admin"));

        return user;

    }
    
    public void registerUser(User user) throws SQLException{
        try {
            int i = stmt.executeUpdate("INSERT INTO LEGOHouse.Users(`username`,`password`,`email`,`admin`)"
                    + " VALUES('"
                    + user.getName()        + "','"
                    + user.getPassword()    + "','"
                    + user.getEmail()       +
                    "',0);");

            if (i == 0) {
                throw new SQLException();
            }

        } catch (SQLException e) {
            throw new SQLException("Error in query: " + e.getErrorCode());
        }
        
    }
    
}
