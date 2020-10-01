package org.camille.controllers.jdbc;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.camille.App;
import org.camille.pojo.Supplier;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Select all details for one supplier using DB Statement and display results in graphic components (FXML)
 *
 * @see Supplier
 */
public class SelectSupplierController implements Initializable {
    // FXML variables
    @FXML
    private TextField supplierCode, supplierName, supplierZipCode, supplierCity, supplierContactName;
    @FXML
    private TextArea supplierAddress;
    @FXML
    private Button btn_search, btn_menu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * On click on search button.
     *
     * @throws SQLException : Sql Exception
     */
    public void btnSearch_click() throws SQLException {
        // Clear inputs values
        this.supplierName.setText("");
        this.supplierContactName.setText("");
        this.supplierAddress.setText("");
        this.supplierCity.setText("");
        this.supplierZipCode.setText("");

        // DB Statement using Supplier object's method supplierByNumfou and result display
        try {
            ResultSet rs = new Supplier().SupplierByNumfou(this.supplierCode.getText());

            if (rs.next()) {
                this.supplierName.setText(rs.getString("nomfou"));
                this.supplierContactName.setText(rs.getString("confou"));
                this.supplierAddress.setText(rs.getString("ruefou"));
                this.supplierCity.setText(rs.getString("vilfou"));
                this.supplierZipCode.setText(rs.getString("posfou"));
            } else {
                this.supplierCode.setText("CE CODE FOURNISSEUR N'EXISTE PAS DANS LA BASE DE DONNEES");
            }
            rs.close();

        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
            this.supplierCode.setText("ERREUR");
        }
    }

    /**
     * On click on back to menu button.
     *
     * @throws IOException
     */
    @FXML
    private void btn_menu_click() throws IOException {
        App.setRoot("/views/menu");
    }
}
