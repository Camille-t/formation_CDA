package org.camille.pojo;

import org.camille.controllers.jdbc.Connection;

import java.sql.*;

/**
 * Supplier class
 *
 * @see Connection
 */
public class Supplier {
    // Variables
    private int satisf, numfou;
    private String nomfou, ruefou, posfou, vilfou, confou;

    // Connection package
    private final java.sql.Connection connection;

    /**
     * Default constructor.
     */
    public Supplier() {
        this.connection = new Connection("papyrus").connection();
    }

    /**
     * Supplier constructor with parameters.
     *
     * @param nomfou : Supplier's name
     * @param ruefou : Supplier's address
     * @param posfou : Supplier's ZipCode
     * @param vilfou : Supplier's city
     * @param confou : Supplier's contact name
     */
    public Supplier(String nomfou, String ruefou, String posfou, String vilfou, String confou) {
        this.nomfou = nomfou;
        this.ruefou = ruefou;
        this.posfou = posfou;
        this.vilfou = vilfou;
        this.confou = confou;
        this.connection = new Connection("papyrus").connection();
    }

    /**
     * Select supplier by code (numfou).
     *
     * @param numfou : Supplier's code (primary key)
     * @return all datas regarding one supplier
     * @throws SQLException : Sql Exception
     */
    public ResultSet SupplierByNumfou(String numfou) throws SQLException {
        return this.connection.createStatement().executeQuery("SELECT * FROM fournis WHERE numfou = " + numfou);
    }

    /**
     * Select all suppliers and sort by name (nomfou).
     *
     * @return List of all suppliers
     * @throws SQLException : Sql Exception
     */
    public ResultSet suppliersList() throws SQLException {
        return this.connection.createStatement().executeQuery("SELECT * FROM fournis ORDER BY nomfou ASC");
    }

    /**
     * Select all orders' details for one supplier
     *
     * @param supplier : String value of supplier's code
     * @return Orders' details for selected supplier
     * @throws SQLException : Sql Exception
     */
    public ResultSet ordersDetailsBySupplier(String supplier) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM entcom JOIN fournis ON entcom.numfou = fournis.numfou WHERE fournis.nomfou = ?");
        ps.setString(1, supplier);
        return ps.executeQuery();
    }

    /**
     * Select all order's details for all suppliers
     *
     * @return Orders' details for all suppliers
     * @throws SQLException :
     */
    public ResultSet ordersDetailsForAllSuppliers() throws SQLException {
        return this.connection.createStatement().executeQuery("SELECT * FROM entcom JOIN fournis ON entcom.numfou = fournis.numfou");
    }

    /**
     * Method used to add new supplier's code based on db's numfou
     *
     * @return biggest supplier's code (numfou)
     * @throws SQLException : SQL exception
     */
    public int getNewNumfou() throws SQLException {
        Statement stm = this.connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT numfou FROM fournis ORDER BY numfou DESC LIMIT 1");
        if (rs.next())
            return rs.getInt("numfou");
        else
            return 0;
    }

    /**
     * Method to create new Supplier in DB.
     *
     * @return boolean : true if new supplier has been added to the DB
     */
    public boolean addNewSupplier() {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO fournis(numfou, nomfou, ruefou, posfou, vilfou, confou) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, this.getNewNumfou() + 1);
            ps.setString(2, nomfou);
            ps.setString(3, ruefou);
            ps.setString(4, posfou);
            ps.setString(5, vilfou);
            ps.setString(6, confou);
            ps.execute();
            ps.close();
            this.connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
