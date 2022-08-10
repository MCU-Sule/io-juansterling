module com.example.pt07_2072009 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.pt07_2072009 to javafx.fxml;
    exports com.example.pt07_2072009;

    opens com.example.pt07_2072009.model to com.google.gson;
    exports com.example.pt07_2072009.model;
}