module org.example.rsagui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.rsagui to javafx.fxml;
    exports org.example.rsagui;
}