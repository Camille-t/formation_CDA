package org.camille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Scene scene;

    /**
     * On start show menu
     *
     * @param stage : Stage for the primary stage
     * @throws IOException : Exception
     * @see org.camille.controllers.jdbc.MenuController
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/views/menu"));
        stage.setScene(scene);
        stage.setTitle("Papyrus");
        stage.show();
    }

    /**
     * Set root use loadFXML function to add views on the scene
     *
     * @param fxml : String to fxml files
     * @throws IOException : Exception
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Function to define and load fxml files
     *
     * @param fxml : String to fxml file
     * @return FXMLLoader file
     * @throws IOException : Exception
     */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main class to launch app
     *
     * @param args : Main arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
