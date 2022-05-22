package com.example.motosharing.controllers;

import javafx.fxml.FXML;

public class SelectLocationController extends MainAppController
{
    @FXML
    private void handleTimisoara() { mainApp.showOrderBikesScreen(); }

    @FXML
    private void handleIasi() {mainApp.showOrderBikesScreen(); }

    @FXML
    private void handldeClujNapoca() { mainApp.showOrderBikesScreen(); }

    @FXML
    private void handldeBucharest() { mainApp.showOrderBikesScreen(); }

    @FXML
    private void handldeBrasov() { mainApp.showOrderBikesScreen(); }

    @FXML
    private void handleConstanta() { mainApp.showOrderBikesScreen(); }

}
