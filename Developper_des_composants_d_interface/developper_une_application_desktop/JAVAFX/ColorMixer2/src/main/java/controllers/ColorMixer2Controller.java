package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorMixer2Controller implements Initializable {
    // Fxml variables
    @FXML
    private Label lbl4, lblRed, lblBlue, lblGreen;
    @FXML
    private Slider sliderRed, sliderGreen, sliderBlue;

    // Class variables
    private Number redValue = 0;
    private Number greenValue = 0;
    private Number blueValue = 0;

    // Controller class initialization.

    // sets lbl4 fxml background color using RGB initial values(0,0,0)
    // Adds event listeners on sliders' value property
    // stores slider's new_value in Number variable
    // display new color mix using displayColors() method
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl4.setStyle("-fx-background-color: rgb(" + redValue + "," + greenValue + "," + blueValue + ")");
        sliderRed.valueProperty().addListener((evt, old_value, new_value) -> {
            redValue = new_value;
            displayColors(redValue);
        });
        sliderGreen.valueProperty().addListener((evt, old_value, new_value) -> {
            greenValue = new_value;
            displayColors(greenValue);
        });
        sliderBlue.valueProperty().addListener((evt, old_value, new_value) -> {
            blueValue = new_value;
            displayColors(blueValue);
        });
    }

    // Class functions

    // sets lbl4 fxml background color using RGB values
    public void displayColors (Number colorValue) {
        lbl4.setStyle("-fx-background-color: rgb(" + redValue + "," + greenValue + "," + blueValue + ")");
    }
}
