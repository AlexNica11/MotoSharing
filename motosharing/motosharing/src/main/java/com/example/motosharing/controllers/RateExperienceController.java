package com.example.motosharing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RateExperienceController extends MainAppController
{

    @FXML
   /* private TextField ratingField;

    private String[] ratingNr = new String[5];
    int i;
    private void setRatingValues()
    {
        for(int i = 1; i < 5; i++)

    }
    @FXML
   private void initialize()
    {
        setRatingValues()
    }*/
    private void handleFinish()
    {
        /*String errorMessage="";
        if(ratingField.getText()==null || ratingField.getText().trim().length()==0){
            errorMessage+="Please rate your experience\n";*/

        mainApp.showGoodbyeScreen();
    }
}
