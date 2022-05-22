package com.example.motosharing.controllers;

import javafx.fxml.FXML;

public class EmployeeEditController extends MainAppController{

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
}
