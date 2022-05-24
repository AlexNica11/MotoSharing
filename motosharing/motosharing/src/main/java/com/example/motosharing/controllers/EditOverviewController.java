package com.example.motosharing.controllers;

import com.example.motosharing.MainApp;
import com.example.motosharing.data.Bike;
import com.example.motosharing.data.Data;
import com.example.motosharing.data.Locations;
import com.example.motosharing.users.Customer;
import com.example.motosharing.users.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

                dataLabel1.setText(((Locations) data).getCity());
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
        if(option.equals("ratings")){
            if (data != null) {
                designationLabel1.setText("Review");
                designationLabel2.setVisible(false);
                designationLabel3.setVisible(false);
                designationLabel4.setVisible(false);

                dataLabel1.setText(((Customer) data).getReview());
                dataLabel2.setVisible(false);
                dataLabel3.setVisible(false);
                dataLabel4.setVisible(false);
            } else {
                designationLabel1.setText("Review");
                designationLabel2.setVisible(false);
                designationLabel3.setVisible(false);
                designationLabel4.setVisible(false);

                dataLabel1.setText("");
                dataLabel2.setVisible(false);
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
        Data tempData=null;

        if(option.equals("locations")) {
            tempData= new Locations();
        }
        if(option.equals("bike info")) {
            tempData= new Bike();
        }
        if(option.equals("employee details")) {
            tempData= new Employee();
        }
        if(option.equals("ratings")) {
            tempData= new Customer();
        }

        boolean okClicked= mainApp.showEditDialog(tempData, option);

        if(okClicked) {
            if(option.equals("locations")) {
                mainApp.getLocations().add(tempData);
            }
            if(option.equals("bike info")) {
                mainApp.getBikeData().add(tempData);
            }
            if(option.equals("employee details")) {
                mainApp.getEmployeeData().add(tempData);
            }
            if(option.equals("ratings")) {
                mainApp.getCustomerData().add(tempData);
            }
        }
        // TODO: 22/05/2022 this implementation is only for locations, must be for all options
    }
    @FXML
    private void handleEdit(){
        Data selectedData= table.getSelectionModel().getSelectedItem();
        if(selectedData!=null){
            boolean okClicked= mainApp.showEditDialog(selectedData, option);
            if(okClicked)
                showDetails(selectedData);
        }else{
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select an entry in the table");

            alert.showAndWait();
        }

    }
    @FXML
    private void handleDelete(){
        int selectedIndex= table.getSelectionModel().getSelectedIndex();
        if(selectedIndex>=0)
            table.getItems().remove(selectedIndex);
        else{
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select an entry in the table");

            alert.showAndWait();
        }
    }

    public void setMainApp(MainApp mainApp, String option){
        this.mainApp= mainApp;
        this.option= option;

        if(option.equals("locations")) {
            table.setItems(mainApp.getLocations());

            firstColumn.setText("City");
            secondColumn.setText("Street");

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

            firstColumn.setText("Manufacturer");
            secondColumn.setText("Model");

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

            firstColumn.setText("Name");
            secondColumn.setText("Rank");

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

        if(option.equals("ratings")){
            table.setItems(mainApp.getCustomerData());

            firstColumn.setText("Name");
            secondColumn.setText("Email");

            firstColumn.setCellValueFactory(
                    cellData-> ((Customer) cellData.getValue()).getNameProperty()
            );
            secondColumn.setCellValueFactory(
                    cellData-> ((Customer) cellData.getValue()).getEmailProperty()
            );

            showDetails(null);

            table.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> showDetails(newValue)
            );
        }
    }
}
