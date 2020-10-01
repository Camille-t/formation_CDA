module org.afpa {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.afpa to javafx.fxml;
    exports org.afpa;
}