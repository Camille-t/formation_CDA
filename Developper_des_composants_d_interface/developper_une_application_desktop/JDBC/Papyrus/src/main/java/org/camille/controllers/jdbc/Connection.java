package org.camille.controllers.jdbc;

import java.sql.DriverManager;

public class Connection {
    // Users' variables
    private final String url;
    private final String user;
    private final String pwd;

    /**
     * Class Connection Constructor with the DataBase's name in parameter.
     * @param dbName : database name (String)
     */
    public Connection(String dbName) {
        this.url = "jdbc:mysql://localhost:3306/"+ dbName +"?serverTimezone=UTC";
        this.user = "root";
        this.pwd = "";
    }

    /**
     * Connection method.
     * @return The connection to the Database
     */
    public java.sql.Connection connection() {
        try {
            // Connection
            return DriverManager.getConnection(this.url, this.user, this.pwd);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
