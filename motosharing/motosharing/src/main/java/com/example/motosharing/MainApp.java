package com.example.motosharing;

import com.example.motosharing.controllers.*;
import com.example.motosharing.data.Bike;
import com.example.motosharing.data.Data;
import com.example.motosharing.data.Locations;
import com.example.motosharing.users.Customer;
import com.example.motosharing.users.Employee;
import com.example.motosharing.users.User;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;


    private User user;
    private ObservableList<Data> customerData= FXCollections.observableArrayList();
    private ObservableList<Data> employeeData= FXCollections.observableArrayList();
    private ObservableList<Data> locations=FXCollections.observableArrayList();
    private ObservableList<Data> bikes=FXCollections.observableArrayList();

    public MainApp(){
        Customer customer1= new Customer("u1", "p1");
        Customer customer2= new Customer("u2", "p2");
        Customer customer3= new Customer("u3", "p3");
        Customer customer4= new Customer("u4", "p4");
        Customer customer5= new Customer("u5", "p5");
        Customer customer6= new Customer("u6", "p6");
        Customer customer7= new Customer("user - sheesh", "p6");
        customer1.setReview("review1");
        customer2.setReview("review2");
        customer3.setReview("review3");
        customer4.setReview("review4");
        customer5.setReview("review5");

        customerData.add(customer1);
        customerData.add(customer2);
        customerData.add(customer3);
        customerData.add(customer4);
        customerData.add(customer5);
        customerData.add(customer6);
        customerData.add(customer7);

        employeeData.add(new Employee("e1", "p1", "employee", "pp1"));
        employeeData.add(new Employee("e2", "p2", "manager", "pp2"));
        employeeData.add(new Employee("e3", "p3", "employee", "pp3"));
        employeeData.add(new Employee("e4", "p4", "employee", "pp4"));
        employeeData.add(new Employee("e5", "p5", "employee", "pp5"));
        employeeData.add(new Employee("e6", "p6", "manager", "pp6"));

        locations.add(new Locations("c1", "s1", "sn1"));
        locations.add(new Locations("c2", "s2", "sn2"));
        locations.add(new Locations("c3", "s3", "sn3"));
        locations.add(new Locations("c4", "s4", "sn4"));
        locations.add(new Locations("c5", "s5", "sn5"));
        for (Data loc : locations){
            Locations loc1= ((Locations) loc);
            Bike b1= new Bike("m11", "mo11", "c11", "e11");
            b1.setLocation(loc1);
            Bike b2= new Bike("m12", "mo12", "c12", "e12");
            b2.setLocation(loc1);
            Bike b3= new Bike("m13", "mo13", "c13", "e13");
            b3.setLocation(loc1);
            Bike b4= new Bike("m14", "mo14", "c14", "e14");
            b4.setLocation(loc1);
            Bike b5= new Bike("m15", "mo15", "c15", "e15");
            b5.setLocation(loc1);
            loc1.addBike(b1);
            loc1.addBike(b2);
            loc1.addBike(b3);
            loc1.addBike(b4);
            loc1.addBike(b5);

            bikes.addAll(loc1.getBikeList());
        }
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
            controller.setUser();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showEditOverview(String option){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EditOverview.fxml"));
            AnchorPane editOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(editOverview);

            EditOverviewController controller = loader.getController();
            controller.setMainApp(this, option);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showEditDialog(Data data, String option){
        try{
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EditDialog.fxml"));
            AnchorPane page= (AnchorPane) loader.load();

            Stage dialogStage= new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene= new Scene(page);
            dialogStage.setScene(scene);

            EditDialogController controller= loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setData(data, option);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<Data> getCustomerData(){
        return customerData;
    }

    public void addNewCustomer(Customer customer){
        customerData.add(customer);
    }
    public ObservableList<Data> getEmployeeData(){
        return employeeData;
    }

    public void addNewEmployee(Employee employee){
        employeeData.add(employee);
    }
    public ObservableList<Data> getLocations(){
        return locations;
    }

    public ObservableList<Data> getBikeData(){
        return bikes;
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public void setUser(User user){
        this.user= user;
    }
    public User getUser(){
        return user;
    }

    public static void main(String[] args) {
        launch();
    }
}
