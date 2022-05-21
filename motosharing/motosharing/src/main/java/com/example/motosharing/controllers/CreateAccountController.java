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
        Customer customer= new Customer(nameField.getText(), passwordField.getText());
        customer.setEmail(emailField.getText());
        customer.setDateOfBirth(birthDay.getValue()+"."+birthMonth.getValue()+"."+birthYear);
        customer.setCreditCard(Integer.parseInt(creditCardField.getText()));
        customer.setCardOwner(cardOwnerField.getText());
        customer.setExpirationDate(expirationMonth.getValue()+"."+expirationYear);
        customer.setSecurityCode(Integer.parseInt(securityCodeField.getText()));

        mainApp.addNewCustomer(customer);

        mainApp.showFirstScreen();
    }

}
