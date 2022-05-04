module com.example.motosharing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.motosharing to javafx.fxml;
    exports com.example.motosharing;
}