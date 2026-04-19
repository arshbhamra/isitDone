module org.example.again {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.again to javafx.fxml;
    exports org.example.again;
}