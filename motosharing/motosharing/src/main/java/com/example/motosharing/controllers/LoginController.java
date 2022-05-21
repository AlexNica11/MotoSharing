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
        //mainApp.showCreateAccountScreen();
        customerData=mainApp.getCustomerData();
        String username=usernameField.getText();
        String password=passwordField.getText();
        boolean login=false;
        /*customerData.forEach((customer)->{
            if(customer.getName()==username && customer.getPassword()==password){

            }
        });*/

        for(Customer customer : customerData){
            //System.out.println("login "+login+" user "+customer.getName()+" pass "+customer.getPassword());
            if(customer.getName().equals(username) && customer.getPassword().equals(password)){
                login=true;
            }
        }
        //System.out.println("login "+login+" user "+username+" pass "+password);
        if(login==true){
            mainApp.showCreateAccountScreen();
        }
        else{
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Unsuccessful login");
            alert.setHeaderText("Username or password not correct");
            alert.setContentText("Please enter the correct account details");

            alert.showAndWait();
        }
    }
}
