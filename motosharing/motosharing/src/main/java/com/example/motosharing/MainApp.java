package com.example.motosharing;

import com.example.motosharing.controllers.*;
import com.example.motosharing.users.Customer;
import com.example.motosharing.users.Employee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    private ObservableList<Customer> customerData= FXCollections.observableArrayList();
    private ObservableList<Employee> employeeData= FXCollections.observableArrayList();

    public MainApp(){
        customerData.add(new Customer("u1", "p1"));
        customerData.add(new Customer("u2", "p2"));
        customerData.add(new Customer("u3", "p3"));
        customerData.add(new Customer("u4", "p4"));
        customerData.add(new Customer("u5", "p5"));
        customerData.add(new Customer("u6", "p6"));
        customerData.add(new Customer("user - sheesh", "p6"));


        employeeData.add(new Employee("e1", "p1", "employee", "pp1"));
        employeeData.add(new Employee("e2", "p2", "manager", "pp2"));
        employeeData.add(new Employee("e3", "p3", "employee", "pp3"));
        employeeData.add(new Employee("e4", "p4", "employee", "pp4"));
        employeeData.add(new Employee("e5", "p5", "employee", "pp5"));
        employeeData.add(new Employee("e6", "p6", "manager", "pp6"));
    }

    public void start(Stage primaryStage){
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("MotoSharing");

        initRootLayout();

        showFirstScreen();
    }

    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout= loader.load();

            Scene scene= new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller= loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showFirstScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("first_screen.fxml"));
            Pane firstScreen=loader.load();

            rootLayout.setCenter(firstScreen);

            FirstScreenController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showLoginScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("login.fxml"));
            Pane loginScreen=loader.load();

            rootLayout.setCenter(loginScreen);

            LoginController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showCreateAccountScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("createAcnt.fxml"));
            AnchorPane createAccountScreen=loader.load();

            rootLayout.setCenter(createAccountScreen);

            CreateAccountController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showEmployeeEdit(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EmployeeEdit.fxml"));
            AnchorPane employeeEditScreen=loader.load();

            rootLayout.setCenter(employeeEditScreen);

            EmployeeEditController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Customer> getCustomerData(){
        return customerData;
    }

    public void addNewCustomer(Customer customer){
        customerData.add(customer);
    }
    public ObservableList<Employee> getEmployeeData(){
        return employeeData;
    }

    public void addNewEmployee(Employee employee){
        employeeData.add(employee);
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
