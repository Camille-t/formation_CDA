package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Form1Controller implements Initializable {

    @FXML
    private TextField textField1;
    @FXML
    private Label label1;
    @FXML
    private CheckBox checkBoxChoiceBackgroundColor, checkBoxChoiceTextColor, checkBoxChoiceCaseSensitive;
    @FXML
    private TitledPane titledPaneBackgroundColor, titledPaneTextColor, titledPaneChoice, titledPaneCaseSensitive;
    @FXML
    private RadioButton radioButtonBackgroundColorRed, radioButtonBackgroundColorGreen, radioButtonBackgroundColorBlue,
            radioButtonTextColorRed, radioButtonTextColorWhite, radioButtonTextColorBlack, radioButtonCaseSensitiveLowerCase,
            radioButtonCaseSensitiveUpperCase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void textField1_keyTyped(KeyEvent keyEvent) {
        String str = textField1.getText();
        label1.setText(str);
        titledPaneChoice.setVisible(true);
        titledPaneChoice.setDisable(false);
        checkBoxChoiceBackgroundColor.setDisable(false);
        checkBoxChoiceTextColor.setDisable(false);
        checkBoxChoiceCaseSensitive.setDisable(false);
    }


    @FXML
    private void checkBoxChoiceBackgroundColor_click(ActionEvent actionEvent) {
        if (checkBoxChoiceBackgroundColor.isSelected()) {
            titledPaneBackgroundColor.setDisable(false);
            radioButtonBackgroundColorRed.setDisable(false);
            radioButtonBackgroundColorGreen.setDisable(false);
            radioButtonBackgroundColorBlue.setDisable(false);
        } else {
            titledPaneBackgroundColor.setDisable(true);
            radioButtonBackgroundColorRed.setDisable(true);
            radioButtonBackgroundColorRed.setSelected(false);
            radioButtonBackgroundColorGreen.setDisable(true);
            radioButtonBackgroundColorGreen.setSelected(false);
            radioButtonBackgroundColorBlue.setDisable(true);
            radioButtonBackgroundColorBlue.setSelected(false);
            label1.setStyle("-fx-background-color: none;");
        }
    }

    @FXML
    private void checkBoxChoiceTextColor_click(ActionEvent actionEvent) {
        if (checkBoxChoiceTextColor.isSelected()) {
            titledPaneTextColor.setDisable(false);
            radioButtonTextColorRed.setDisable(false);
            radioButtonTextColorWhite.setDisable(false);
            radioButtonTextColorBlack.setDisable(false);
        } else {
            titledPaneTextColor.setDisable(true);
            radioButtonTextColorRed.setDisable(true);
            radioButtonTextColorRed.setSelected(false);
            radioButtonTextColorWhite.setDisable(true);
            radioButtonTextColorWhite.setSelected(false);
            radioButtonTextColorBlack.setDisable(true);
            radioButtonTextColorBlack.setSelected(true);
            label1.setStyle("-fx-text-fill: black;");
        }
    }

    @FXML
    private void checkBoxChoiceCaseSensitive_click(ActionEvent actionEvent) {
        if (checkBoxChoiceCaseSensitive.isSelected()) {
            titledPaneCaseSensitive.setDisable(false);
            radioButtonCaseSensitiveLowerCase.setDisable(false);
            radioButtonCaseSensitiveUpperCase.setDisable(false);
        }
        else {
            titledPaneCaseSensitive.setDisable(true);
            radioButtonCaseSensitiveLowerCase.setDisable(true);
            radioButtonCaseSensitiveLowerCase.setSelected(false);
            radioButtonCaseSensitiveUpperCase.setDisable(true);
            radioButtonCaseSensitiveUpperCase.setSelected(false);
            label1.setText(textField1.getText());
        }
    }

    @FXML
    private void radioButtonBackgroundColorRed_click(ActionEvent actionEvent) {
        if (radioButtonBackgroundColorRed.isSelected() && radioButtonTextColorRed.isSelected())
            label1.setStyle("-fx-background-color: red;-fx-text-fill: red;");
        else if (radioButtonBackgroundColorRed.isSelected() && radioButtonTextColorWhite.isSelected())
            label1.setStyle("-fx-background-color: red;-fx-text-fill: white" );
        else
            label1.setStyle("-fx-background-color: red; -fx-text-fill: black");
    }

    @FXML
    private void radioButtonBackgroundColorGreen_click(ActionEvent actionEvent) {
        if (radioButtonBackgroundColorGreen.isSelected() && radioButtonTextColorRed.isSelected())
            label1.setStyle("-fx-background-color: green;-fx-text-fill: red;");
        else if (radioButtonBackgroundColorGreen.isSelected() && radioButtonTextColorWhite.isSelected())
            label1.setStyle("-fx-background-color: green;-fx-text-fill: white" );
        else
            label1.setStyle("-fx-background-color: green; -fx-text-fill: black");
    }

    @FXML
    private void radioButtonBackgroundColorBlue_click(ActionEvent actionEvent) {
        if (radioButtonBackgroundColorBlue.isSelected() && radioButtonTextColorRed.isSelected())
            label1.setStyle("-fx-background-color: blue;-fx-text-fill: red;");
        else if (radioButtonBackgroundColorBlue.isSelected() && radioButtonTextColorWhite.isSelected())
            label1.setStyle("-fx-background-color: blue;-fx-text-fill: white" );
        else
            label1.setStyle("-fx-background-color: blue; -fx-text-fill: black");
    }

    @FXML
    private void radioButtonTextColorRed_click(ActionEvent actionEvent) {
        if (radioButtonBackgroundColorRed.isSelected() && radioButtonTextColorRed.isSelected())
            label1.setStyle("-fx-background-color: red;-fx-text-fill: red;");
        else if (radioButtonBackgroundColorGreen.isSelected() && radioButtonTextColorRed.isSelected())
            label1.setStyle("-fx-background-color: green;-fx-text-fill: red" );
        else if(radioButtonBackgroundColorBlue.isSelected() && radioButtonTextColorRed.isSelected())
            label1.setStyle("-fx-background-color: blue; -fx-text-fill: red");
        else
            label1.setStyle("-fx-text-fill: red");
    }

    @FXML
    private void radioButtonTextColorWhite_click(ActionEvent actionEvent) {
        if (radioButtonBackgroundColorRed.isSelected() && radioButtonTextColorWhite.isSelected())
            label1.setStyle("-fx-background-color: red;-fx-text-fill: white;");
        else if (radioButtonBackgroundColorGreen.isSelected() && radioButtonTextColorWhite.isSelected())
            label1.setStyle("-fx-background-color: green;-fx-text-fill: white" );
        else if(radioButtonBackgroundColorBlue.isSelected() && radioButtonTextColorWhite.isSelected())
            label1.setStyle("-fx-background-color: blue; -fx-text-fill: white");
        else
            label1.setStyle("-fx-text-fill: white");
    }

    @FXML
    private void radioButtonTextColorBlack_click(ActionEvent actionEvent) {
        if (radioButtonBackgroundColorRed.isSelected() && radioButtonTextColorBlack.isSelected())
            label1.setStyle("-fx-background-color: red;-fx-text-fill: black;");
        else if (radioButtonBackgroundColorGreen.isSelected() && radioButtonTextColorBlack.isSelected())
            label1.setStyle("-fx-background-color: green;-fx-text-fill: black" );
        else if(radioButtonBackgroundColorBlue.isSelected() && radioButtonTextColorBlack.isSelected())
            label1.setStyle("-fx-background-color: blue; -fx-text-fill: black");
        else
            label1.setStyle("-fx-text-fill: black");
    }

    @FXML
    private void radioButtonCaseSensitiveLowerCase_click(ActionEvent actionEvent) {
        if(radioButtonCaseSensitiveLowerCase.isSelected())
            label1.setText(label1.getText().toLowerCase());
    }

    @FXML
    private void radioButtonCaseSensitiveUpperCase_click(ActionEvent actionEvent) {
        if(radioButtonCaseSensitiveUpperCase.isSelected())
            label1.setText(label1.getText().toUpperCase());
    }
}
