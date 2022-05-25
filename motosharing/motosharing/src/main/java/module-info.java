module com.example.motosharing {
    requires javafx.controls;
    requires javafx.fxml;
    //requires com.google.gson;
    requires json.simple;

    opens com.example.motosharing to javafx.fxml, com.google.gson;
    opens com.example.motosharing.controllers to javafx.fxml;
    opens com.example.motosharing.users to javafx.fxml;


    exports com.example.motosharing.controllers;
    exports com.example.motosharing;
    exports com.example.motosharing.users;
    exports com.example.motosharing.data;
}