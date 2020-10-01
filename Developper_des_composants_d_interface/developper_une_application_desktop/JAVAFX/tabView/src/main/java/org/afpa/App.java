package org.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
 Application class is the entry point for JavaFX applications and performs the following functions:
 Application.launch() ==> construit une instance de la classe Application spécifiée (App)
 Application.launch() ==> builds an instance of the specified Application class (App)
 call to the init() method
 call to the start method(javafx.stage.Stage)
 Awaits completion of the application
 call the stop() method
*/
public class App extends Application {

    // start() method loads .fxml file(s) in a Scene and transmits it to the Stage element (content of the main window of the application).
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("tab1.fxml")); // view path
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView");
        primaryStage.show();
    }

    // main() method launches the app
    public static void main(String[] args) {
        launch(args);
    }
}
