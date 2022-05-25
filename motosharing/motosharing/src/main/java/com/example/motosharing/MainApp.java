package com.example.motosharing;

import com.example.motosharing.controllers.*;
import com.example.motosharing.data.Bike;
import com.example.motosharing.data.Data;
import com.example.motosharing.data.Locations;
import com.example.motosharing.users.Customer;
import com.example.motosharing.users.Employee;
import com.example.motosharing.users.User;
//import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class MainApp extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;


    private User user;
    private ObservableList<Data> customerData= FXCollections.observableArrayList();
    private ObservableList<Data> employeeData= FXCollections.observableArrayList();
    private ObservableList<Data> locations=FXCollections.observableArrayList();
    private ObservableList<Data> bikes=FXCollections.observableArrayList();

    public MainApp(){
        /*Customer customer1= new Customer("u1", "p1".hashCode());
        Customer customer2= new Customer("u2", "p2".hashCode());
        Customer customer3= new Customer("u3", "p3".hashCode());
        Customer customer4= new Customer("u4", "p4".hashCode());
        Customer customer5= new Customer("u5", "p5".hashCode());
        Customer customer6= new Customer("u6", "p6".hashCode());
        Customer customer7= new Customer("user - sheesh", "p6".hashCode());
        customer1.setReview("review1");
        customer2.setReview("review2");
        customer3.setReview("review3");
        customer4.setReview("review4");
        customer5.setReview("review5");*/

        /*customerData.add(customer1);
        customerData.add(customer2);
        customerData.add(customer3);
        customerData.add(customer4);
        customerData.add(customer5);
        customerData.add(customer6);
        customerData.add(customer7);*/

        loadCustomerDataFromFile();
        loadEmployeeDataFromFile();
        loadBikeDataFromFile();
        loadLocationsDataFromFile();

        /*employeeData.add(new Employee("e1", "p1".hashCode(), "employee", "pp1".hashCode()));
        employeeData.add(new Employee("e2", "p2".hashCode(), "manager", "pp2".hashCode()));
        employeeData.add(new Employee("e3", "p3".hashCode(), "employee", "pp3".hashCode()));
        employeeData.add(new Employee("e4", "p4".hashCode(), "employee", "pp4".hashCode()));
        employeeData.add(new Employee("e5", "p5".hashCode(), "employee", "pp5".hashCode()));
        employeeData.add(new Employee("e6", "p6".hashCode(), "manager", "pp6".hashCode()));

        locations.add(new Locations("c1", "s1", "sn1"));
        locations.add(new Locations("c2", "s2", "sn2"));
        locations.add(new Locations("c3", "s3", "sn3"));
        locations.add(new Locations("c4", "s4", "sn4"));
        locations.add(new Locations("c5", "s5", "sn5"));
        for (Data loc : locations){
            Locations loc1= ((Locations) loc);
            //Bike b1= new Bike("m11", "mo11", "c11", "e11");
            //b1.setLocation(loc1);
            Bike b2= new Bike("m12", "mo12", "c12", "e12");
            b2.setLocation(loc1);
            Bike b3= new Bike("m13", "mo13", "c13", "e13");
            b3.setLocation(loc1);
            Bike b4= new Bike("m14", "mo14", "c14", "e14");
            b4.setLocation(loc1);
            Bike b5= new Bike("m15", "mo15", "c15", "e15");
            b5.setLocation(loc1);
            loc1.addBike(b1);
            loc1.addBike(b2);
            loc1.addBike(b3);
            loc1.addBike(b4);
            loc1.addBike(b5);

            bikes.addAll(loc1.getBikeList());
        }

        saveCustomerDataToFile();
        saveEmployeeDataToFile();
        saveBikeDataToFile();
        saveLocationsDataToFile();*/

    }

    public void start(Stage primaryStage){
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("MotoSharing");

        initRootLayout();

        showFirstScreen();
    }

    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout= loader.load();

            Scene scene= new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller= loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showFirstScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("first_screen.fxml"));
            Pane firstScreen=loader.load();

            rootLayout.setCenter(firstScreen);

            FirstScreenController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showLoginScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("login.fxml"));
            Pane loginScreen=loader.load();

            rootLayout.setCenter(loginScreen);

            LoginController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showCreateAccountScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("createAcnt.fxml"));
            AnchorPane createAccountScreen=loader.load();

            rootLayout.setCenter(createAccountScreen);

            CreateAccountController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showEmployeeEdit(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EmployeeEdit.fxml"));
            AnchorPane employeeEditScreen=loader.load();

            rootLayout.setCenter(employeeEditScreen);

            EmployeeEditController controller= loader.getController();
            controller.setMainApp(this);
            controller.setUser();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showEditOverview(String option){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EditOverview.fxml"));
            AnchorPane editOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(editOverview);

            EditOverviewController controller = loader.getController();
            controller.setMainApp(this, option);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
    public void showSelectLocationScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("chooseCity.fxml"));
            Pane selectLocationScreen=loader.load();

            rootLayout.setCenter(selectLocationScreen);
=======
    public void showPlaceOrderScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("placeOrder.fxml"));
            Pane orderBikesScreen=loader.load();

            rootLayout.setCenter(orderBikesScreen);
>>>>>>> 4306325... Rate experience use case begun

            OrderBikesController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showPlaceOrderScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("placeOrder.fxml"));
            Pane orderBikesScreen=loader.load();

            rootLayout.setCenter(orderBikesScreen);

            OrderBikesController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showRateExperienceScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("rateExperience.fxml"));
            Pane RateExperienceScreen=loader.load();

            rootLayout.setCenter(RateExperienceScreen);

            RateExperienceController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showGoodbyeScreen(){
        try {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("goodbye.fxml"));
            Pane GoodbyeScreen=loader.load();

            rootLayout.setCenter(GoodbyeScreen);

            GoodbyeController controller= loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean showEditDialog(Data data, String option){
        try{
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EditDialog.fxml"));
            AnchorPane page= (AnchorPane) loader.load();

            Stage dialogStage= new Stage();
            dialogStage.setTitle("Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene= new Scene(page);
            dialogStage.setScene(scene);

            EditDialogController controller= loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setData(data, option);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public ObservableList<Data> getCustomerData(){
        return customerData;
    }

    public void addNewCustomer(Customer customer){
        customerData.add(customer);
    }
    public ObservableList<Data> getEmployeeData(){
        return employeeData;
    }

    public void addNewEmployee(Employee employee){
        employeeData.add(employee);
    }
    public ObservableList<Data> getLocations(){
        return locations;
    }

    public ObservableList<Data> getBikeData(){
        return bikes;
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public void setUser(User user){
        this.user= user;
    }
    public User getUser(){
        return user;
    }
    public void saveCustomerDataToFile(){
        // TODO: 25/05/2022 Add JSON file setups
        // TODO: 25/05/2022 2 different JSON libraries, watch out which you are using
        JSONArray arr= new JSONArray();
        for(Data customer : customerData){
            JSONObject c_data= new JSONObject();
            JSONObject c_wrapper= new JSONObject();

            c_data.put("Username", ((Customer)customer).getName());
            c_data.put("Password", ((Customer)customer).getPassword());
            c_data.put("Email", ((Customer)customer).getEmail());
            c_data.put("DateOfBirth", ((Customer)customer).getDateOfBirth());
            c_data.put("CreditCardNr", ((Customer)customer).getCreditCard());
            c_data.put("CardOwner", ((Customer)customer).getCardOwner());
            c_data.put("ExpirationDate", ((Customer)customer).getExpirationDate());
            c_data.put("Security Code", ((Customer)customer).getSecurityCode());
            c_data.put("Review", ((Customer) customer).getReview());

            c_wrapper.put("customer", c_data);

            arr.add(c_wrapper);
        }

        try (FileWriter file = new FileWriter("customers.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(arr.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parseCustomerObject(JSONObject customer){
        JSONObject customerObject= (JSONObject) customer.get("customer");

        Customer cus= new Customer((String) customerObject.get("Username"), ((Long) customerObject.get("Password")).intValue());

        cus.setName((String) customerObject.get("Username"));
        cus.setPassword(((Long) customerObject.get("Password")).intValue());
        cus.setEmail((String) customerObject.get("Email"));
        cus.setDateOfBirth((String) customerObject.get("DateOfBirth"));
        cus.setCreditCard(((Long) customerObject.get("CreditCardNr")).intValue());
        cus.setCardOwner((String) customerObject.get("CardOwner"));
        cus.setExpirationDate((String) customerObject.get("ExpirationDate"));
        cus.setSecurityCode(((Long) customerObject.get("Security Code")).intValue());
        cus.setReview((String) customerObject.get("Review"));

        customerData.add(cus);
    }
    public void loadCustomerDataFromFile(){
        JSONParser jsonParser= new JSONParser();
        try(FileReader reader= new FileReader("customers.json")) {
            Object obj= jsonParser.parse(reader);

            JSONArray customerList= (JSONArray) obj;

            customerList.forEach( cus -> parseCustomerObject( (JSONObject) cus) );
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void saveEmployeeDataToFile(){
        JSONArray arr= new JSONArray();
        for(Data employee : employeeData){
            JSONObject e_data= new JSONObject();
            JSONObject e_wrapper= new JSONObject();

            e_data.put("Username", ((Employee)employee).getName());
            e_data.put("Password", ((Employee)employee).getPassword());
            e_data.put("Rank", ((Employee)employee).getRank());
            e_data.put("EmployeePassword", ((Employee)employee).getEmployeePassword());

            e_wrapper.put("employee", e_data);

            arr.add(e_wrapper);
        }

        try (FileWriter file = new FileWriter("employees.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(arr.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseEmployeeObject(JSONObject employee){
        JSONObject employeeObject= (JSONObject) employee.get("employee");

        Employee emp= new Employee((String) employeeObject.get("Username"), ((Long) employeeObject.get("Password")).intValue(), (String) employeeObject.get("Rank"), ((Long) employeeObject.get("EmployeePassword")).intValue());

        employeeData.add(emp);
    }

    public void loadEmployeeDataFromFile(){
        JSONParser jsonParser= new JSONParser();
        try(FileReader reader= new FileReader("employees.json")) {
            Object obj= jsonParser.parse(reader);

            JSONArray customerList= (JSONArray) obj;

            customerList.forEach( emp -> parseEmployeeObject( (JSONObject) emp) );
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void saveBikeDataToFile(){
        JSONArray arr= new JSONArray();
        for(Data bike : bikes){
            JSONObject b_data= new JSONObject();
            JSONObject b_wrapper= new JSONObject();

            b_data.put("Manufacturer", ((Bike)bike).getManufacturer());
            b_data.put("Model", ((Bike)bike).getModel());
            b_data.put("Color", ((Bike)bike).getColor());
            b_data.put("EngineSize", ((Bike)bike).getEngineSize());

            b_wrapper.put("bike", b_data);

            arr.add(b_wrapper);
        }

        try (FileWriter file = new FileWriter("bikes.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(arr.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseBikeObject(JSONObject bike){
        JSONObject bikeObject= (JSONObject) bike.get("bike");

        Bike bike1= new Bike((String) bikeObject.get("Manufacturer"), (String) bikeObject.get("Model"), (String) bikeObject.get("Color"), (String) bikeObject.get("EngineSize"));

        bikes.add(bike1);
    }

    public void loadBikeDataFromFile(){
        JSONParser jsonParser= new JSONParser();
        try(FileReader reader= new FileReader("bikes.json")) {
            Object obj= jsonParser.parse(reader);

            JSONArray bikeList= (JSONArray) obj;

            bikeList.forEach( bike -> parseBikeObject( (JSONObject) bike) );
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void saveLocationsDataToFile(){
        JSONArray arr= new JSONArray();
        for(Data loc : locations){
            JSONObject l_data= new JSONObject();
            JSONObject l_wrapper= new JSONObject();

            l_data.put("City", ((Locations) loc).getCity());
            l_data.put("Street", ((Locations) loc).getStreet());
            l_data.put("StreetNumber", ((Locations) loc).getStreetNumber());

            JSONArray bikeArr= new JSONArray();
            for(Data bike : ((Locations) loc).getBikeList()){
                JSONObject b_data= new JSONObject();
                JSONObject b_wrapper= new JSONObject();

                b_data.put("Manufacturer", ((Bike)bike).getManufacturer());
                b_data.put("Model", ((Bike)bike).getModel());
                b_data.put("Color", ((Bike)bike).getColor());
                b_data.put("EngineSize", ((Bike)bike).getEngineSize());

                b_wrapper.put("bike", b_data);
                bikeArr.add(b_wrapper);
            }

            l_data.put("Bikes", bikeArr);

            l_wrapper.put("location", l_data);

            arr.add(l_wrapper);
        }

        try (FileWriter file = new FileWriter("locations.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(arr.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseLocationsObject(JSONObject location){
        JSONObject locationObject= (JSONObject) location.get("location");

        //Bike bike1= new Bike((String) bikeObject.get("Manufacturer"), (String) bikeObject.get("Model"), (String) bikeObject.get("Color"), (String) bikeObject.get("EngineSize"));

        Locations loc= new Locations((String) locationObject.get("City"), (String) locationObject.get("Street"), (String) locationObject.get("StreetNumber"));

        JSONArray locationArr=(JSONArray) locationObject.get("Bikes");

        for(Object bike : locationArr){
            JSONObject bikeObject= (JSONObject) ((JSONObject)bike).get("bike");

            Bike bike1= new Bike((String) bikeObject.get("Manufacturer"), (String) bikeObject.get("Model"), (String) bikeObject.get("Color"), (String) bikeObject.get("EngineSize"));

            loc.addBike(bike1);
        }

        locations.add(loc);
    }

    private void loadLocationsDataFromFile(){
        JSONParser jsonParser= new JSONParser();
        try(FileReader reader= new FileReader("locations.json")) {
            Object obj= jsonParser.parse(reader);

            JSONArray locationsList=(JSONArray) obj;

            locationsList.forEach(loc ->parseLocationsObject((JSONObject) loc));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
