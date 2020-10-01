package org.camille.controllers.jdbc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.camille.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rs) {

    }

    @FXML
    public void btn_ex1_click() throws IOException {
        App.setRoot("/views/jdbc/select_supplier");
    }

    @FXML
    public void btn_ex2_click() throws IOException {
        App.setRoot("/views/jdbc/select_orders_by_supplier_name");
    }

    @FXML
    public void btn_ex3_click() throws IOException {
        App.setRoot("/views/jdbc/add_supplier");
    }
}
