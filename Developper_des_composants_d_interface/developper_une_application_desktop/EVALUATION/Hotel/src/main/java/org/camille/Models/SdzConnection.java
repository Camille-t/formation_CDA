package org.camille.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection Class. Creates instance of Connexion Object using singleton pattern
 *
 */
public class SdzConnection {

    // Connexion parameters
    private static String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
    private static String user = "root";
    private static String pwd = "";
    private static Connection con; // Connection Object

    // private Constructor
    private SdzConnection() {
        try {
            con = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that will return the instance or create it if it doesn't already exist.
     *
     * @return Connection object
     */
    public static Connection getInstance() {
        if(con == null) {
            new SdzConnection();
        }
        return con;
    }
}