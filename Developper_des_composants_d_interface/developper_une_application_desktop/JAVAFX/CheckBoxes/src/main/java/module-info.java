module com.afpa {
    requires javafx.controls;
    requires javafx.fxml;

    opens controllers to javafx.fxml;
    exports com.afpa;
}