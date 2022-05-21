package com.example.motosharing.controllers;

import com.example.motosharing.MainApp;
import com.example.motosharing.users.Customer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginController extends MainAppController{

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    private ObservableList<Customer> customerData;

    @FXML
    private void initialize(){

    }
    @FXML
    private void handleVerify(){
        customerData=mainApp.getCustomerData();
        String username=usernameField.getText();
        String password=passwordField.getText();

        String errorMessage="";

        if(username==null || username.trim().length()==0)
            errorMessage+="Username field is empty.\n";
        if(password==null || password.trim().length()==0)
            errorMessage+="Password field is empty.\n";

        boolean login=false;


        for(Customer customer : customerData){

            if(customer.getName().equals(username) && customer.getPassword().equals(password)){
                login=true;
            }
        }

        if(login==true){
            mainApp.showCreateAccountScreen();
        }
        else{
            errorMessage+="Please enter the correct account details.\n";
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Unsuccessful login");
            alert.setHeaderText("Username or password not correct");
            alert.setContentText(errorMessage);

            alert.showAndWait();
        }
    }
}
