package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorMixerController implements Initializable {

    @FXML
    private Label lbl4;
    @FXML
    private Label lblRed;
    @FXML
    private Label lblBlue;
    @FXML
    private Label lblGreen;
    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sliderRed.setMin(0);
        sliderRed.setMax(255);
        sliderRed.setValue(0);
        sliderGreen.setMin(0);
        sliderGreen.setMax(255);
        sliderGreen.setValue(0);
        sliderBlue.setMin(0);
        sliderBlue.setMax(255);
        sliderBlue.setValue(0);
        lbl4.setStyle("-fx-background-color: rgb(0,0,0)");
    }

    @FXML
    private void sliderRed_mouseReleased(MouseEvent mouseEvent) {
        double redValue = sliderRed.getValue();
        double greenValue = sliderGreen.getValue();
        double blueValue = sliderBlue.getValue();
        lbl4.setStyle("-fx-background-color: rgb(" + redValue + "," + greenValue + "," + blueValue +")");
    }

    @FXML
    private void sliderGreen_mouseReleased(MouseEvent mouseEvent) {
        double redValue = sliderRed.getValue();
        double greenValue = sliderGreen.getValue();
        double blueValue = sliderBlue.getValue();
        lbl4.setStyle("-fx-background-color: rgb(" + redValue + "," + greenValue + "," + blueValue +")");
    }

    @FXML
    private void sliderBlue_mouseReleased(MouseEvent mouseEvent) {
        double redValue = sliderRed.getValue();
        double greenValue = sliderGreen.getValue();
        double blueValue = sliderBlue.getValue();
        lbl4.setStyle("-fx-background-color: rgb(" + redValue + "," + greenValue + "," + blueValue +")");
    }
}
