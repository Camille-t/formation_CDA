package org.camille.controllers.jdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.camille.App;
import org.camille.pojo.Supplier;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Add new supplier to DB using datas from graphic components.
 *
 * @see Supplier
 */
public class AddSupplierController implements Initializable {
    //FXML variables
    @FXML
    private TextField textField_supplierName, textField_supplierAddress, textField_supplierContactName, textField_supplierZipCode, textField_supplierCity;
    @FXML
    private Button btn_addNewSupplier, btn_cancel;

    // Class variables
    private boolean isValid;
    private String errorMessage = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * On click on add button
     *
     * @throws SQLException
     */
    @FXML
    private void btn_addNewSupplier_click() throws SQLException {
        // define values
        String newSupplierName = this.textField_supplierName.getText();
        String newSupplierAddress = this.textField_supplierAddress.getText();
        String newSupplierContact = this.textField_supplierContactName.getText();
        String newSupplierZipCode = this.textField_supplierZipCode.getText();
        String newSupplierCity = this.textField_supplierCity.getText();
        // define patterns
        String addressPattern = "^((\\d)+[a-zA-Zéèêëàáâîïç\\-\\s]{6,40})$"; // a number followed by 6 to 40 characters
        String wordPattern = "^[éèêëàáâîïç\\w]{3,20}$";
        String zipCodePattern = "^[0-9]{5}$";
        // patterns tests on values
        this.isValid = true;
        this.filterValue(newSupplierName, wordPattern, "Le nom du fournisseur n'est pas valide.");
        this.filterValue(newSupplierAddress, addressPattern, "L'adresse du fournisseur n'est pas valide.");
        this.filterValue(newSupplierContact, wordPattern, "Le nom du contact n'est pas valide.");
        this.filterValue(newSupplierZipCode, zipCodePattern, "Le code postal saisi n'est pas valide.");
        this.filterValue(newSupplierCity, wordPattern, "La ville saisie n'est pas valide.");
        // define new Supplier
        Supplier newSupplier = new Supplier(newSupplierName, newSupplierAddress, newSupplierZipCode, newSupplierCity, newSupplierContact);
        // addNewSupplier : returns boolean true if new supplier is added to the db
        if (this.isValid) {
            if (newSupplier.addNewSupplier()) {
                btn_cancel_click();
                this.alert("Nouveau fournisseur ajouté avec succès", Alert.AlertType.INFORMATION);
            }
        } else
            this.alert(this.errorMessage, Alert.AlertType.ERROR);
    }

    /**
     * Defines pattern tests.
     *
     * @param textField : input values to be tested
     * @param pattern : pattern used for testing
     * @param message : error message to display in case of no match between input values and pattern
     */
    private void filterValue(String textField, String pattern, String message) {
        if (!textField.matches(pattern)) {
            this.isValid = false;
            this.errorMessage = message;
        }
    }

    /**
     * Defines alert for error messages.
     *
     * @param message : error message to be displayed
     * @param alertType : type of alert to be used
     * @throws SQLException : SQL Exception
     */
    private void alert(String message, Alert.AlertType alertType) throws SQLException {
        Alert alert = new Alert(alertType);
        alert.setTitle("Ajout d'un nouveau fournisseur");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * On click on cancel button : clear all values in textFields.
     *
     */
    @FXML
    private void btn_cancel_click() {
        this.textField_supplierAddress.setText("");
        this.textField_supplierCity.setText("");
        this.textField_supplierZipCode.setText("");
        this.textField_supplierContactName.setText("");
        this.textField_supplierName.setText("");
    }

    /**
     * On click on back to menu button.
     *
     * @throws IOException : IOException
     */
    @FXML
    private void btn_menu_click() throws IOException {
        App.setRoot("/views/menu");
    }
}
