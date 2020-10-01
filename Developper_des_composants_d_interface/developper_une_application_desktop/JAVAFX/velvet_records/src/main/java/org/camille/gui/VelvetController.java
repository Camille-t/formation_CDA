package org.camille.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class VelvetController implements Initializable {
    @FXML
    private Label albumTitle, albumAuthor;
    @FXML
    private ImageView albumCover;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        albumTitle.setText("Dirt");
        albumAuthor.setText("Alice in Chains");
        Image image = new Image(String.valueOf(getClass().getResource("pictures/Dirt.jpeg")));
        albumCover.setImage(image);
    }
}
