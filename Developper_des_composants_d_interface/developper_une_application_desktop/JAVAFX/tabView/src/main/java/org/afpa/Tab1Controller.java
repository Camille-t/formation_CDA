package org.afpa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Tab1Controller implements Initializable {
    @FXML
    private TableView<Client> lst_clients;
    @FXML
    private TableColumn<Client, String> col_prenom;
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_ville;
    @FXML
    private Label lbl_tab;
    @FXML
    private Label lbl_prenom;
    @FXML
    private Label lbl_nom;
    @FXML
    private Label lbl_ville;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_ville;
    @FXML
    private Button btn_sauver;
    @FXML
    private Button btn_annuler;
    @FXML
    private Button btn_supprimer;


    // Stores our Client objects in an ObservableList (model) that will allow us to fill our TableView
    ObservableList<Client> model = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // model initialization
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        // makes TableView uneditable
        lst_clients.setEditable(false);

        // Junction of the TableView with datas
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));

        // The TableView is told which model to observe to find the data.
        lst_clients.setItems(model);
    }

    // Method to save the new data (call to the method at the event click on the save button)
    // Creates an instance of the Client class using the content of the 3 TextField and add this instance to our model.
    @FXML
    private void sauver(ActionEvent actionEvent) {
        model.add(new Client(txt_nom.getText(),txt_prenom.getText(), txt_ville.getText()));
    }

    // Method to cancel the input (call to the method at the event click on the cancel button)
    // Empties the content of the 3 TextField
    @FXML
    private void annuler(ActionEvent actionEvent) {
        txt_nom.clear();
        txt_prenom.clear();
        txt_ville.clear();
    }

    // Method for deleting a row from the TableView (call to the method at the event click on the delete button)
    // Deletes the line of our model (observableArrayList) from the index corresponding to the line selected by the user.
    @FXML
    private void supprimer(ActionEvent actionEvent) {
        model.remove(lst_clients.getSelectionModel().getSelectedIndex());
    }
}
