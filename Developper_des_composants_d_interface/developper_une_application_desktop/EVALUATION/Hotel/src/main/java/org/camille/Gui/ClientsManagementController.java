package org.camille.Gui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import org.camille.Dal.ClientDAO;
import org.camille.Pojo.Client;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClientsManagementController implements Initializable {
    // FXML variables
    @FXML
    private TableView<Client> clients;
    @FXML
    private TableColumn<Client, String> col_name, col_firstname;
    @FXML
    private Pane pane_details_add, pane_details_update;
    @FXML
    private TextField txt_name_add, txt_firstname_add, txt_city_add, txt_name_update, txt_firstname_update, txt_city_update;

    // Class variables
    private final ClientDAO clientDAO;
    private final ObservableList<Client> clientsList = FXCollections.observableArrayList();
    private Boolean isValid = true;
    private String errorMessage = "";

    // Constructor
    public ClientsManagementController() {
        this.clientDAO = new ClientDAO();
    }

    // Regex patterns
    private final String wordPattern = "^[a-zA-Zéèêëàáâîïç\\-]{3,20}$";
    private final String cityPattern = "^[éèêëàáâîïç\\w\\-\\s]{3,30}$";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // makes TableView uneditable
        clients.setEditable(false);
        pane_details_add.setVisible(false);
        pane_details_update.setVisible(false);
        // Initializes the ArrayList
        ArrayList<Client> dbClients = null;
        // Fills the ArrayList with all Clients from DB
        try {
            dbClients = clientDAO.list();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // adds all the clients from the DB to observableList
        if (dbClients != null) {
            this.clientsList.addAll(dbClients);
        }
        // Junction of the TableView with datas
        this.col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        // sets items for TableView
        this.clients.setItems(clientsList);
    }

    /**
     * Defines pattern tests.
     *
     * @param textField : input values to be tested
     * @param pattern   : pattern used for testing
     * @param message   : error message to display in case of no match between input values and pattern
     */
    private void filterValue(String textField, String pattern, String message) {
        if (!textField.matches(pattern)) {
            this.isValid = false;
            this.errorMessage = message;
        }
    }

    /**
     * Defines and display alerts for error messages.
     *
     * @param message   : error message to be displayed
     * @param alertType : type of alert to be used
     * @throws SQLException : SQL Exception
     */
    private void alert(String message, Alert.AlertType alertType) throws SQLException {
        Alert alert = new Alert(alertType);
        alert.setTitle("Gestion des clients");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Confirms an action through an alert
     *
     * @param buttons The buttons to use
     * @return The values from the confirmation
     */
    public static ButtonType confirm(ButtonType... buttons) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setContentText("Êtes vous sûr ?");
        alert.setTitle("Confirmation");

        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(buttons);

        Optional<ButtonType> option = alert.showAndWait();

        return option.isEmpty() ? null : option.get();
    }

    @FXML
    private void btn_reset_click_add() {
        txt_name_add.setText("");
        txt_firstname_add.setText("");
        txt_city_add.setText("");
    }

    @FXML
    private void btn_reset_click_update() throws SQLException {
        int id = clients.getSelectionModel().getSelectedItem().getId();
        Client cli = clientDAO.find(id);
        txt_name_update.setText(cli.getName());
        txt_firstname_update.setText(cli.getFirstname());
        txt_city_update.setText(cli.getCity());
    }

    @FXML
    private void btn_add_click() {
        pane_details_add.setVisible(true);
        txt_name_add.setText("");
        txt_firstname_add.setText("");
        txt_city_add.setText("");
        pane_details_update.setVisible(false);
    }

    @FXML
    private void btn_ok_click_add() throws SQLException {
        // defines new Client
        Client cli = new Client();
        // gets user's values
        cli.setName(txt_name_add.getText());
        cli.setFirstname(txt_firstname_add.getText());
        cli.setCity(txt_city_add.getText());
        cli.setId(Objects.requireNonNull(clientDAO.getLastClient()).getId()+1);
        isValid = true;
        // patterns tests on values
        filterValue(cli.getName(), wordPattern, "Le format du nom saisi n'est pas valide.");
        filterValue(cli.getFirstname(), wordPattern, "Le format du prénom saisi n'est pas valide.");
        filterValue(cli.getCity(), cityPattern, "Le format de la ville saisie n'est pas valide.");
        // adds new ClientDAO to DB if patterns tests return true
        try {
            if (isValid) {
                clientDAO.insert(cli);
                // adds the new Client to the TableView
                clientsList.add(cli); // defines and display updated clients list (with new client)
                alert("Le nouveau client a bien été ajouté à la base de données de l'hôtel.", Alert.AlertType.INFORMATION);
            } else {
                alert(errorMessage, Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btn_update_click() throws SQLException {
        pane_details_add.setVisible(false);
        pane_details_update.setVisible(true);
        // Finds the client with the given id
        Client cli = clientDAO.find(clients.getSelectionModel().getSelectedItem().getId());
        txt_name_update.setText(cli.getName());
        txt_firstname_update.setText(cli.getFirstname());
        txt_city_update.setText(cli.getCity());
    }

    @FXML
    private void btn_ok_click_update() throws SQLException {
        Client cli = clientDAO.find(clients.getSelectionModel().getSelectedItem().getId());
        cli.setName(txt_name_update.getText());
        cli.setFirstname(txt_firstname_update.getText());
        cli.setCity(txt_city_update.getText());
        // patterns tests on values
        isValid = true;
        filterValue(cli.getName(), wordPattern, "Le format du nom saisi n'est pas valide.");
        filterValue(cli.getFirstname(), wordPattern, "Le format du prénom saisi n'est pas valide.");
        filterValue(cli.getCity(), cityPattern, "Le format de la ville saisie n'est pas valide.");

        if (isValid) {
            try {
                clientDAO.update(cli);

                clientsList.remove(clients.getSelectionModel().getSelectedIndex());

                clientsList.add(cli);

                alert("Les coordonnées du client ont bien été modifiées dans la base de données de l'hôtel.", Alert.AlertType.INFORMATION);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            alert(errorMessage, Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void btn_delete_click() throws SQLException {
        pane_details_add.setVisible(false);
        pane_details_update.setVisible(false);
        try {
            // Creates the buttons type for the confirmation
            ButtonType cancel = new ButtonType("Annuler");
            ButtonType confirm = new ButtonType("Confirmer");

            // Sends the confirmation alert to the user
            ButtonType isConfirmed = confirm(cancel, confirm);

            // If the user confirms deleting

            assert isConfirmed != null;
            if (isConfirmed.equals(confirm)) {
                Client cli = clientDAO.find(clients.getSelectionModel().getSelectedItem().getId());

                // Deletes the client from the database
                assert cli != null;
                clientDAO.delete(cli);

                // Removes the client from the TableView
                clientsList.remove(clients.getSelectionModel().getSelectedIndex());

                // Sends an information alert to the user
                alert("Le client a bien été supprimé de la base de données de l'hôtel.", Alert.AlertType.INFORMATION);
            } else {
                // Sends an information alert to the user
                alert(errorMessage, Alert.AlertType.ERROR);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

