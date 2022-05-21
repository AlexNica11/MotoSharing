package com.example.motosharing.controllers;

import com.example.motosharing.users.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateAccountController extends MainAppController{

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField creditCardField;
    @FXML
    private TextField cardOwnerField;
    @FXML
    private TextField securityCodeField;
    @FXML
    private TextField passwordField;
    @FXML
    private ComboBox<String> birthDay;
    @FXML
    private ComboBox<String> birthMonth;
    @FXML
    private ComboBox<String> birthYear;
    @FXML
    private ComboBox<String> expirationMonth;
    @FXML
    private ComboBox<String> expirationYear;


    private String[] days= new String[31];
    private String[] months= new String[12];
    private String[] years= new String[72];

    private void setDateValues(){
        for(int i=0;i<72;i++){
            if(i<31) {
                days[i] = "";
                days[i] += (i + 1);
            }
            if(i<12) {
                months[i] = "";
                months[i] +=(i+1);
            }
            years[i]="";
            years[i]+=(i+1950);
        }
    }

    @FXML
    private void initialize(){
        setDateValues();
        birthDay.setItems(FXCollections.observableArrayList(days));
        birthDay.setValue("Day");

        birthMonth.setItems(FXCollections.observableArrayList(months));
        birthMonth.setValue("Month");

        birthYear.setItems(FXCollections.observableArrayList(years));
        birthYear.setValue("Year");

        expirationMonth.setItems(FXCollections.observableArrayList(months));
        expirationMonth.setValue("Month");

        expirationYear.setItems(FXCollections.observableArrayList(years));
        expirationYear.setValue("Year");
    }

    @FXML
    public void handleContinue(){
        String errorMessage="";
        if(nameField.getText()==null || nameField.getText().trim().length()==0){
            errorMessage+="Username field is empty.\n";
        }
        if(emailField.getText()==null || emailField.getText().trim().length()==0){
            errorMessage+="Email field is empty.\n";
        }
        if(passwordField.getText()==null || passwordField.getText().trim().length()==0){
            errorMessage+="Password field is empty.\n";
        }
        if(creditCardField.getText()==null || creditCardField.getText().trim().length()==0){
            errorMessage+="Credit card number field is empty.\n";
        }
        else {
            try {
                Integer.parseInt(creditCardField.getText());
            }catch (NumberFormatException e){
                errorMessage+="Credit card field must be a number.\n";
            }
        }
        if(cardOwnerField.getText()==null || cardOwnerField.getText().trim().length()==0){
            errorMessage+="Card owner field is empty.\n";
        }
        if(securityCodeField.getText()==null || securityCodeField.getText().trim().length()==0){
            errorMessage+="Security code field is empty.\n";
        }
        else {
            try {
                Integer.parseInt(securityCodeField.getText());
            }catch (NumberFormatException e){
                errorMessage+="Security code field must be a number.\n";
            }
        }
        if(birthDay.getValue().equals("Day") || birthMonth.getValue().equals("Month") || birthYear.getValue().equals("Year")){
            errorMessage+="Date of Birth field is empty.\n";
        }
        if( expirationMonth.getValue().equals("Month") || expirationYear.getValue().equals("Year")){
            errorMessage+="Expiration date field is empty.\n";
        }

        if(errorMessage!=""){
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
        }else {
            Customer customer = new Customer(nameField.getText(), passwordField.getText());
            customer.setEmail(emailField.getText());
            customer.setDateOfBirth(birthDay.getValue() + "." + birthMonth.getValue() + "." + birthYear);
            customer.setCreditCard(Integer.parseInt(creditCardField.getText()));
            customer.setCardOwner(cardOwnerField.getText());
            customer.setExpirationDate(expirationMonth.getValue() + "." + expirationYear);
            customer.setSecurityCode(Integer.parseInt(securityCodeField.getText()));

            mainApp.addNewCustomer(customer);

            mainApp.showFirstScreen();
        }
    }
}
