package com.example.motosharing.controllers;

import com.example.motosharing.data.Bike;
import com.example.motosharing.data.Data;
import com.example.motosharing.data.Locations;
import com.example.motosharing.users.Customer;
import com.example.motosharing.users.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialogController extends MainAppController{

    private Stage dialogStage;
    private Data data;
    private boolean okClicked=false;
    private String option;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private void handleOk(){
        if(isInputValid()) {
            if (option.equals("locations"))
                if (data != null) {
                    ((Locations) data).setCity(textField1.getText());
                    ((Locations) data).setStreet(textField2.getText());
                    ((Locations) data).setStreetNumber(textField3.getText());

                    okClicked = true;
                    dialogStage.close();
                }

            if (option.equals("bike info"))
                if (data != null) {
                    ((Bike) data).setManufacturer(textField1.getText());
                    ((Bike) data).setModel(textField2.getText());
                    ((Bike) data).setColor(textField3.getText());
                    ((Bike) data).setEngineSize(textField4.getText());

                    okClicked = true;
                    dialogStage.close();
                }


            if (option.equals("employee details"))
                if (data != null) {
                    ((Employee) data).setName(textField1.getText());
                    ((Employee) data).setRank(textField2.getText());

                    okClicked = true;
                    dialogStage.close();
                }


            if (option.equals("ratings"))
                if (data != null) {
                    ((Customer) data).setName(textField1.getText());
                    ((Customer) data).setEmail(textField2.getText());
                    ((Customer) data).setReview(textField3.getText());

                    okClicked = true;
                    dialogStage.close();
                }
        }
    }


    @FXML
    private void handleCancel(){
        dialogStage.close();
    }


    public void setData(Data data, String option){
        this.data= data;
        this.option= option;

        if(option.equals("locations")) {
            if (data != null) {
                label1.setText("City");
                label2.setText("Street");
                label3.setText("StreetNumber");
                label4.setVisible(false);

                textField1.setText(((Locations) data).getCity());
                textField2.setText(((Locations) data).getStreet());
                textField3.setText(((Locations) data).getStreetNumber());
                textField4.setVisible(false);
            }
        }
        if(option.equals("bike info")){
            if (data != null) {
                label1.setText("Manufacturer");
                label2.setText("Model");
                label3.setText("Color");
                label4.setText("Engine size");

                textField1.setText(((Bike) data).getManufacturer());
                textField2.setText(((Bike) data).getModel());
                textField3.setText(((Bike) data).getColor());
                textField4.setText(((Bike) data).getEngineSize());
            }
        }
        if(option.equals("employee details")){
            if (data != null) {
                label1.setText("Name");
                label2.setText("Rank");
                label3.setVisible(false);
                label4.setVisible(false);

                textField1.setText(((Employee) data).getName());
                textField2.setText(((Employee) data).getRank());
                textField3.setVisible(false);
                textField4.setVisible(false);
            }
        }
        if(option.equals("ratings")){
            if (data != null) {
                label1.setText("Name");
                label2.setText("Email");
                label3.setText("Review");
                label4.setVisible(false);

                textField1.setText(((Customer) data).getName());
                textField2.setText(((Customer) data).getEmail());
                textField3.setText(((Customer) data).getReview());
                textField4.setVisible(false);
            }
        }
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage= dialogStage;
    }

    public boolean isOkClicked(){
        return okClicked;
    }

    public boolean isInputValid(){
        String errorMessage= "";

        if(option.equals("locations")) {
            if(textField1.getText()==null || textField1.getText().length()==0)
                errorMessage+="City name field is empty\n";
            if(textField2.getText()==null || textField2.getText().length()==0)
                errorMessage+="Street name field is empty\n";
            if(textField3.getText()==null || textField3.getText().length()==0)
                errorMessage+="Street number field is empty\n";
            else {
                try {
                    Integer.parseInt(textField3.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Street number field must be a number.\n";
                }
            }
        }
        if(option.equals("bike info")){
            if(textField1.getText()==null || textField1.getText().length()==0)
                errorMessage+="Manufacturer field is empty\n";
            if(textField2.getText()==null || textField2.getText().length()==0)
                errorMessage+="Model field is empty\n";
            if(textField3.getText()==null || textField3.getText().length()==0)
                errorMessage+="Color field is empty\n";
            if(textField4.getText()==null || textField4.getText().length()==0)
                errorMessage+="Engine size field is empty\n";
            else {
                try {
                    Integer.parseInt(textField4.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Engine size field must be a number.\n";
                }
            }
        }
        if(option.equals("employee details")){
            if(textField1.getText()==null || textField1.getText().length()==0)
                errorMessage+="Name field is empty\n";
            if(textField2.getText()==null || textField2.getText().length()==0)
                errorMessage+="Rank field is empty\n";
        }
        if(option.equals("ratings")){
            if(textField1.getText()==null || textField1.getText().length()==0)
                errorMessage+="Name field is empty\n";
            if(textField2.getText()==null || textField2.getText().length()==0)
                errorMessage+="Email field is empty\n";
            if(textField3.getText()==null || textField3.getText().length()==0)
                errorMessage+="Review field is empty\n";
        }

        if(errorMessage.length()==0)
            return true;
        else{
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }

}
