package com.example.motosharing.controllers;

import javafx.fxml.FXML;

public class FirstScreenController extends MainAppController{

    @FXML
    private void handleLogin(){
        mainApp.showLoginScreen();
    }

    @FXML
    private void handleCreateAccount(){
        mainApp.showCreateAccountScreen();
    }
}
