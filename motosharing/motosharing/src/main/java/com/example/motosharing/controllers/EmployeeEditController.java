package com.example.motosharing.controllers;

import com.example.motosharing.MainApp;
import com.example.motosharing.users.Employee;
import com.example.motosharing.users.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.nio.Buffer;

public class EmployeeEditController extends MainAppController{

    private User user;
    @FXML
    private Button locations;
    @FXML
    private Button employeeDetails;

    @FXML
    private void handleBikeInfo(){
        mainApp.showEditOverview("bike info");
    }
    @FXML
    private void handleReservations(){
        mainApp.showEditOverview("reservation");
    }
    @FXML
    private void handleNrOfBikes(){
        mainApp.showEditOverview("nr of bikes");
    }
    @FXML
    private void handleLocations(){
        mainApp.showEditOverview("locations");
    }
    @FXML
    private void handleEmployeeDetails(){
        mainApp.showEditOverview("employee details");
    }
    @FXML
    private void handleRatings(){
        mainApp.showEditOverview("ratings");
    }
    @FXML
    private void handleLogOut(){
        mainApp.showLoginScreen();
    }

    public void setUser(){
        user=mainApp.getUser();
        if(((Employee)user).getRank().equals("employee")){
            locations.setVisible(false);
            employeeDetails.setVisible(false);
        }
    }
}
