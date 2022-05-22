package com.example.motosharing.controllers;

import com.example.motosharing.MainApp;
import com.example.motosharing.data.Bike;
import com.example.motosharing.data.Data;
import com.example.motosharing.data.Locations;
import com.example.motosharing.users.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EditOverviewController extends MainAppController{

    //private Data data;
    private String option;
    @FXML
    private TableView<Data> table;
    @FXML
    private TableColumn<Data, String> firstColumn;
    @FXML
    private TableColumn<Data, String> secondColumn;
    @FXML
    private Label designationLabel1;
    @FXML
    private Label designationLabel2;
    @FXML
    private Label designationLabel3;
    @FXML
    private Label designationLabel4;
    @FXML
    private Label dataLabel1;
    @FXML
    private Label dataLabel2;
    @FXML
    private Label dataLabel3;
    @FXML
    private Label dataLabel4;

    private void showDetails(Data data){
        if(option.equals("locations")) {
            if (data != null) {
                designationLabel1.setText("City");
                designationLabel2.setText("Street");
                designationLabel3.setText("StreetNumber");
                designationLabel4.setVisible(false);

                dataLabel1.setText(((Locations) data).getStreet());
                dataLabel2.setText(((Locations) data).getStreet());
                dataLabel3.setText(((Locations) data).getStreetNumber());
                dataLabel4.setVisible(false);
            } else {
                designationLabel1.setText("City");
                designationLabel2.setText("Street");
                designationLabel3.setText("StreetNumber");
                designationLabel4.setVisible(false);

                dataLabel1.setText("");
                dataLabel2.setText("");
                dataLabel3.setText("");
                dataLabel4.setVisible(false);
            }
        }
        if(option.equals("bike info")){
            if (data != null) {
                designationLabel1.setText("Manufacturer");
                designationLabel2.setText("Model");
                designationLabel3.setText("Color");
                designationLabel4.setText("Engine size");

                dataLabel1.setText(((Bike) data).getManufacturer());
                dataLabel2.setText(((Bike) data).getModel());
                dataLabel3.setText(((Bike) data).getColor());
                dataLabel4.setText(((Bike) data).getEngineSize());
            } else {
                designationLabel1.setText("City");
                designationLabel2.setText("Street");
                designationLabel3.setText("StreetNumber");
                designationLabel4.setText("Engine size");

                dataLabel1.setText("");
                dataLabel2.setText("");
                dataLabel3.setText("");
                dataLabel4.setText("");
            }
        }
        if(option.equals("employee details")){
            if (data != null) {
                designationLabel1.setText("Name");
                designationLabel2.setText("Rank");
                designationLabel3.setVisible(false);
                designationLabel4.setVisible(false);

                dataLabel1.setText(((Employee) data).getName());
                dataLabel2.setText(((Employee) data).getRank());
                dataLabel3.setVisible(false);
                dataLabel4.setVisible(false);
            } else {
                designationLabel1.setText("Name");
                designationLabel2.setText("Rank");
                designationLabel3.setVisible(false);
                designationLabel4.setVisible(false);

                dataLabel1.setText("");
                dataLabel2.setText("");
                dataLabel3.setVisible(false);
                dataLabel4.setVisible(false);
            }
        }
    }

    @FXML
    private void initialize(){

    }
    @FXML
    private void handleBack(){
        mainApp.showEmployeeEdit();
    }
    @FXML
    private void handleNew(){

    }
    @FXML
    private void handleEdit(){

    }
    @FXML
    private void handleDelete(){

    }

    public void setMainApp(MainApp mainApp, String option){
        this.mainApp= mainApp;
        this.option= option;

        if(option.equals("locations")) {
            table.setItems(mainApp.getLocations());

            firstColumn.setCellValueFactory(
                    cellData-> ((Locations) cellData.getValue()).getCityProperty()
            );
            secondColumn.setCellValueFactory(
                    cellData-> ((Locations) cellData.getValue()).getStreetProperty()
            );

            showDetails(null);

            table.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showDetails(newValue)
            );
        }

        if(option.equals("bike info")) {
            table.setItems(mainApp.getBikeData());

            firstColumn.setCellValueFactory(
                    cellData-> ((Bike) cellData.getValue()).getManufacturerProperty()
            );
            secondColumn.setCellValueFactory(
                    cellData-> ((Bike) cellData.getValue()).getModelProperty()
            );

            showDetails(null);

            table.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showDetails(newValue)
            );
        }

        if(option.equals("employee details")) {
            table.setItems(mainApp.getEmployeeData());
            firstColumn.setCellValueFactory(
                    cellData-> ((Employee) cellData.getValue()).getNameProperty()
            );
            secondColumn.setCellValueFactory(
                    cellData-> ((Employee) cellData.getValue()).getRankProperty()
            );

            showDetails(null);

            table.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showDetails(newValue)
            );
        }
    }
}
