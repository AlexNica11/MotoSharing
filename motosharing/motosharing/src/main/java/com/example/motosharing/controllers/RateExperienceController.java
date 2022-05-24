package com.example.motosharing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RateExperienceController extends MainAppController
{

    @FXML
    private TextField ratingField;

    private String[] ratingNr = new String[5];

    private void setRatingValues()
    {
        for(int i = 1; i < 5; i++)

    }
    private void handleFinish() { mainApp.showGoodbyeScreen(); }
}
