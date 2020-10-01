package org.camille.Test;

import org.camille.Pojo.Client;
import org.camille.Dal.ClientDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientDAOTests {

    private final ClientDAO clientDAO = new ClientDAO();

    @Test
    public void insert() throws SQLException {
        Client cliToInsert = new Client();
        cliToInsert.setName("Jenny");
        cliToInsert.setFirstname("McCarley");
        cliToInsert.setAddress("4157 Big Elm");
        cliToInsert.setCity("Lenexa");

        clientDAO.insert(cliToInsert);

        Client insertedCli = clientDAO.getLastClient();

        assertEquals("Jenny", insertedCli.getName());
        assertEquals("McCarley", insertedCli.getFirstname());
        assertEquals("4157 Big Elm", insertedCli.getAddress());
        assertEquals("Lenexa", insertedCli.getCity());
    }

    @Test
    public void update() throws SQLException {
        Client cliToUpdate = clientDAO.getLastClient();

        cliToUpdate.setName("Smith");
        cliToUpdate.setFirstname("Jane");
        cliToUpdate.setAddress("531 Frank Avenue");
        cliToUpdate.setCity("Springfield");

        clientDAO.update(cliToUpdate);

        Client updatedCli = clientDAO.getLastClient();
        assertEquals("Smith", updatedCli.getName());
        assertEquals("Jane", updatedCli.getFirstname());
        assertEquals("531 Frank Avenue", updatedCli.getAddress());
        assertEquals("Springfield", updatedCli.getCity());
    }

    @Test
    public void find() throws SQLException {
        Client cliToBeFound = clientDAO.find(clientDAO.getLastClient().getId());

        assertEquals("Smith", cliToBeFound.getName());
        assertEquals("Jane", cliToBeFound.getFirstname());
        assertEquals("531 Frank Avenue", cliToBeFound.getAddress());
        assertEquals("Springfield", cliToBeFound.getCity());
    }

    @Test
    public void list() throws SQLException {
        List<Client> clientsList = clientDAO.list();

        Assert.assertNotNull(clientsList);

    }

    @Test
    public void delete() throws SQLException {
        ArrayList<Client> clientsList = clientDAO.list();
        int actualClientListLastId = (clientsList.size() -1);
        int lastClientInsertedId = clientsList.get(actualClientListLastId).getId();

        Client clientToDelete = clientDAO.find(lastClientInsertedId);

        clientDAO.delete(clientToDelete.getId());

        List<Client> updatedList = clientDAO.list();

        assertEquals(actualClientListLastId, updatedList.size());
    }
}