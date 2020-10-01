package org.camille.Dal;

import org.camille.Models.SdzConnection;
import org.camille.Pojo.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class to add CRUD on client table - Data Access Object for Client class
 *
 * @see Client
 */
public final class ClientDAO {
    //local variables
    private final Connection con;
    private final String CREATE_CLIENT = "INSERT INTO client(cli_nom, cli_prenom, cli_adresse, cli_ville) VALUES(?, ?, ?, ?)";
    private final String READ_CLIENT = "SELECT * FROM client WHERE cli_id = ?";
    private final String READ_CLIENTS = "SELECT * FROM client";
    private final String UPDATE_CLIENT = "UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_adresse = ?, cli_ville = ? WHERE cli_id = ?";
    private final String DELETE_CLIENT = "DELETE FROM client WHERE cli_id = ?";
    private final String SELECT_LAST_CLIENT = "SELECT * FROM client ORDER BY cli_id DESC LIMIT 1";

    /**
     * Default constructor with connection to the DB
     */
    public ClientDAO() {
        con = SdzConnection.getInstance();
    }

    /**
     * Method to find the last Client in the database
     *
     * @return The last Client
     * @throws SQLException In case any database error occurs
     */
    public Client getLastClient() throws SQLException {
        // Executes the query and returns the result set
        try (ResultSet rs = con.createStatement().executeQuery(SELECT_LAST_CLIENT)) {
            // Creates a new empty Client object
            Client cli = new Client();
            // While there is a result
            while (rs.next()) {
                cli.setAddress(rs.getString("cli_adresse"));
                cli.setCity(rs.getString("cli_ville"));
                cli.setFirstname(rs.getString("cli_prenom"));
                cli.setId(rs.getInt("cli_id"));
                cli.setName(rs.getString("cli_nom"));
            }
            // Returns the client values or null
            return cli;
        } catch (SQLException e) {
            System.out.println("Error while searching latest entity 'client'");
            return null;
        }
    }

    /**
     * Method to insert new Client into client table (DB).
     *
     * @param cli : Client
     * @throws SQLException In case any error occurs with the DB
     */
    public void insert(Client cli) throws SQLException {
        // Prepared Statement to avoid SQL Injection
        try (PreparedStatement ps = con.prepareStatement(CREATE_CLIENT)) {
            ps.setString(1, cli.getName());
            ps.setString(2, cli.getFirstname());
            ps.setString(3, cli.getAddress());
            ps.setString(4, cli.getCity());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error while inserting entity 'client'");
        }
    }

    /**
     * Method to find one client values by its id.
     *
     * @param id Client's id (we wish to find)
     * @return Client values, else returns null
     * @throws SQLException In case any database error occurs
     */
    public Client find(int id) throws SQLException {
        Client cli = new Client();
        try (PreparedStatement ps = con.prepareStatement(READ_CLIENT)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setAddress(rs.getString("cli_adresse"));
                cli.setCity(rs.getString("cli_ville"));
                cli.setFirstname(rs.getString("cli_prenom"));
                cli.setId(rs.getInt("cli_id"));
                cli.setName(rs.getString("cli_nom"));
            }
            ps.close();
            rs.close();
            return cli;
        } catch (SQLException e) {
            System.out.println("Error while finding entity 'client'");
            return null;
        }
    }

    /**
     * Method to read all Clients from DB.
     *
     * @return List of all Clients
     * @throws SQLException In case any db error occur
     */
    public ArrayList<Client> list() throws SQLException {
        try (ResultSet rs = con.createStatement().executeQuery(READ_CLIENTS)) {
            // Initializes a new Client ArrayList
            ArrayList<Client> clientsList = new ArrayList<>();
            while (rs.next()) {
                Client cli = new Client();
                cli.setAddress(rs.getString("cli_adresse"));
                cli.setCity(rs.getString("cli_ville"));
                cli.setFirstname(rs.getString("cli_prenom"));
                cli.setId(rs.getInt("cli_id"));
                cli.setName(rs.getString("cli_nom"));
                // Adds the client to the ArrayList of clients
                clientsList.add(cli);
            }
            rs.close();
            // Returns the list of clients from the database or null
            return clientsList;
        } catch (SQLException e) {
            System.out.println("Error while reading 'clients' list");
            return null;
        }
    }

    /**
     * Method to update client values into client table.
     *
     * @param cli : Client
     * @throws SQLException in case any error occurs with the DB
     */
    public void update(Client cli) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_CLIENT);
            ps.setString(1, cli.getName());
            ps.setString(2, cli.getFirstname());
            ps.setString(3, cli.getAddress());
            ps.setString(4, cli.getCity());
            ps.setInt(5, cli.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error while updating entity 'client'");
        }
    }

    /**
     * Method to delete client from client table.
     *
     * @param id : Client's id
     * @throws SQLException in case any error occurs with the DB
     */
    public void delete(Client client) throws SQLException {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_CLIENT);
            ps.setInt(1, client.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error while deleting entity 'client'");
        }
    }
}
