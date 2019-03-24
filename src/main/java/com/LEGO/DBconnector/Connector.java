package com.LEGO.DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://207.154.240.49/LEGOHouse";
    private static final String USER = "LEGOHouse";
    private static final String PASSWORD = "Guest1234!";
    private static Connection conn = null;

    
    /**
     * Return connection type for connecting to mysql database
     *  
     * @return Connection
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil.
                ex.printStackTrace();
            }
        }
        return conn;
    }

}
