package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Form1Controller implements Initializable {
    @FXML
    private TextField textfield1;
    @FXML
    private Label label1;
    @FXML
    private Button button1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void button1_click(ActionEvent event) {
        String str = "Bonjour " + this.textfield1.getText();
        this.label1.setText(str);
    }
}
