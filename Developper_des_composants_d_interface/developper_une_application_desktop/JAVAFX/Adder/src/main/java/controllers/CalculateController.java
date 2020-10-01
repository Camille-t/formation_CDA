package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculateController implements Initializable {

    @FXML
    private TextArea textarea1;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    public Button button9;
    @FXML
    public Button buttonReset;
    @FXML
    private Button buttonCalculate;

    private long result = 0;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void button0_click(ActionEvent event) {
        String str = this.button0.getText();
        this.textarea1.appendText("+" + str);
    }

    @FXML
    private void button1_click(ActionEvent event) {
        String str = this.button1.getText();
        this.textarea1.appendText("+" + str);
        result += 1;
    }

    @FXML
    private void button2_click(ActionEvent event) {
        String str = this.button2.getText();
        this.textarea1.appendText("+" + str);
        result += 2;
    }

    @FXML
    private void button3_click(ActionEvent event) {
        String str = this.button3.getText();
        this.textarea1.appendText("+" + str);
        result += 3;
    }

    @FXML
    private void button4_click(ActionEvent event) {
        String str = this.button4.getText();
        this.textarea1.appendText("+" + str);
        result += 4;
    }

    @FXML
    private void button5_click(ActionEvent event) {
        String str = this.button5.getText();
        this.textarea1.appendText("+" + str);
        result += 5;
    }

    @FXML
    private void button6_click(ActionEvent event) {
        String str = this.button6.getText();
        this.textarea1.appendText("+" + str);
        result += 6;
    }

    @FXML
    private void button7_click(ActionEvent event) {
        String str = this.button7.getText();
        this.textarea1.appendText("+" + str);
        result += 7;
    }

    @FXML
    private void button8_click(ActionEvent event) {
        String str = this.button8.getText();
        this.textarea1.appendText("+" + str);
        result += 8;
    }

    @FXML
    private void button9_click(ActionEvent event) {
        String str = this.button9.getText();
        this.textarea1.appendText("+" + str);
        result += 9;
    }

    @FXML
    private void buttonReset_click(ActionEvent event) {
        this.textarea1.clear();
        result = 0;
    }

    @FXML
    private void buttonCalculate_click(ActionEvent event) {
        this.textarea1.appendText("=" + result);
    }

}
