package com.example.motosharing.controllers;

import com.example.motosharing.MainApp;
import com.example.motosharing.users.Customer;
import com.example.motosharing.users.Employee;
import com.example.motosharing.users.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginController extends MainAppController{

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField employeePassword;

    private ObservableList<Customer> customerData;
    private ObservableList<Employee> employeeData;

    @FXML
    private void initialize(){
        employeePassword.setVisible(false);
    }
    @FXML
    private void handleVerify(){
        User user=null;

        customerData=mainApp.getCustomerData();
        employeeData= mainApp.getEmployeeData();
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
                user=customer;
            }
        }

        for(Employee employee : employeeData){

            if(employee.getName().equals(username) && employee.getPassword().equals(password)){
                login=true;
                user=employee;
            }
        }

        if(user==null){
            errorMessage+=" ";
        }

        if(employeePassword.isVisible()) {
            if(employeePassword.getText()==null || employeePassword.getText().trim().length()==0)
                errorMessage+="Employee password field is empty.\n";
            if (((Employee) user).getEmployeePassword().equals(employeePassword.getText()) == false)
                errorMessage += "Employee password is not correct.\n";
            else
                mainApp.showEmployeeEdit();
        }


        if(login){
            if(user instanceof Employee){
                employeePassword.setVisible(true);
            }
            else
                mainApp.showCreateAccountScreen();
        }

        if(errorMessage!=""){
            errorMessage+="Please enter the correct account details.\n";
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Unsuccessful login");
            alert.setHeaderText("Log In values are not correct");
            alert.setContentText(errorMessage);

            alert.showAndWait();
        }
    }
}
