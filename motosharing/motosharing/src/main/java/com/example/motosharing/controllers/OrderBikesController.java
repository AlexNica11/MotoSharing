package com.example.motosharing.controllers;

<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
=======
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
>>>>>>> 4306325... Rate experience use case begun

public class OrderBikesController extends MainAppController
{

    @FXML
<<<<<<< HEAD
    private ComboBox<String> type;
=======
    private ComboBox<String> bikeType;
>>>>>>> 4306325... Rate experience use case begun

    @FXML
    private ComboBox<String> quantity;

    @FXML
    private ComboBox<String> time;

<<<<<<< HEAD
    private String[] bikeTypes= new String[10];
    private String[] nrOfBikes= new String[10];
    private String[] hours = new String[12];

    private void setValues()
    {
        for(int i=0; i<12; i++)
        {
            /*if(i<10)
            {
                bikeTypes[i] = "";
                bikeTypes[i] += (i+1);
            }*/
            if(i<10)
            {
                nrOfBikes[i] = "";
                nrOfBikes[i] += (i+1);
            }
            if(i<12)
            {
                hours[i] = "";
                hours[i] += (i+1);
            }
        }
    }
    @FXML
    private void initialize()
    {
        setValues();
        type.setItems(FXCollections.observableArrayList(bikeTypes));
        type.setValue("Type");

        quantity.setItems(FXCollections.observableArrayList(nrOfBikes));
        quantity.setValue("Quantity");

        time.setItems(FXCollections.observableArrayList(hours));
        time.setValue("Time");
    }


    @FXML
    private void handleConfirm()
    {
        String errorMessage="";

        if (quantity.getValue().equals("Quantity")) {
            errorMessage += "Quantity is empty.\n";
        }

        if (time.getValue().equals("Time")) {
            errorMessage += "Time is empty.\n";
        }

        if (errorMessage != "") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
        }
        else
            mainApp.showRateExperienceScreen();
    }

    @FXML
    private void handleBack()
    {
        mainApp.showSelectLocationScreen();
    }
=======
>>>>>>> 4306325... Rate experience use case begun

}
