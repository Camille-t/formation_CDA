package org.camille.controllers.jdbc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import org.camille.App;
import org.camille.pojo.Supplier;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SelectOrdersBySupplierNameController implements Initializable {
    @FXML
    private ComboBox<String> comboBox_selectSupplier;
    @FXML
    private TextArea textArea_orderDetails;
    // Connection class
    private java.sql.Connection connection;
    @FXML
    private Button btn_menu;

    /**
     * On app start, select and display in ComboBox all suppliers' names.
     *
     * @param url            : URL
     * @param resourceBundle : resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ResultSet rs = new Supplier().suppliersList();
            ObservableList<String> ol = FXCollections.observableArrayList();
            ol.add("TOUS");
            while (rs.next()) {
                ol.add(rs.getString("nomfou"));
            }
            this.comboBox_selectSupplier.setItems(ol);

            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * On click on ComboBox
     *
     * @throws SQLException : Sql Exception
     */
    @FXML
    private void comboBox_action() throws SQLException {
        // DB Statement using Supplier object's method supplierByNumfou and result display
        if (this.comboBox_selectSupplier.getSelectionModel().getSelectedItem().equals("TOUS")) {
            try {
                ResultSet rs = new Supplier().ordersDetailsForAllSuppliers();
                StringBuilder sb = new StringBuilder();
                while (rs.next()) {
                    sb.append(rs.getInt("numcom")).append(" ");
                    sb.append(rs.getDate("datcom")).append(" ");
                    sb.append(rs.getString("obscom")).append("\n");
                    this.textArea_orderDetails.setText(String.valueOf(sb));
                }
                rs.close();
            } catch (SQLException throwable) {
                System.out.println(throwable.getMessage());
            }
        } else {
            try {
                ResultSet rs = new Supplier().ordersDetailsBySupplier(this.comboBox_selectSupplier.getSelectionModel().getSelectedItem());
                StringBuilder sb = new StringBuilder();
                while (rs.next()) {
                    sb.append(rs.getInt("numcom")).append(" ");
                    sb.append(rs.getDate("datcom")).append(" ");
                    sb.append(rs.getString("obscom")).append("\n");
                    this.textArea_orderDetails.setText(String.valueOf(sb));
                }
                rs.close();

            } catch (SQLException throwable) {
                System.out.println(throwable.getMessage());
            }
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
