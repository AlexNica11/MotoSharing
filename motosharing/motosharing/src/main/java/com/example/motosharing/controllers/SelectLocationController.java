package com.example.motosharing.controllers;

import javafx.fxml.FXML;

public class SelectLocationController extends MainAppController
{
    @FXML
    private void handleTimisoara() { mainApp.showPlaceOrderScreen(); }

    @FXML
    private void handleIasi() {mainApp.showPlaceOrderScreen(); }

    @FXML
    private void handleClujNapoca() { mainApp.showPlaceOrderScreen(); }

    @FXML
    private void handleBucharest() { mainApp.showPlaceOrderScreen(); }

    @FXML
    private void handleBrasov() { mainApp.showPlaceOrderScreen(); }

    @FXML
    private void handleConstanta() { mainApp.showPlaceOrderScreen(); }

}
