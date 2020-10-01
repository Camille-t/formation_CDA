package org.camille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class App extends Application {

    /**
     * Main class to launch app
     *
     * @param args : Main arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * On start shows clientsManagement scene
     *
     * @param primaryStage : Stage for the app
     * @throws IOException : Exception
     * @see org.camille.Gui.ClientsManagementController
     */
    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/camille/Gui/clientsManagement.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion des Clients");
        primaryStage.show();
    }
}
