module com.example.alfabank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alfabank to javafx.fxml;
    exports com.example.alfabank;
    exports com.example.alfabank.model;
    opens com.example.alfabank.model to javafx.fxml;
}