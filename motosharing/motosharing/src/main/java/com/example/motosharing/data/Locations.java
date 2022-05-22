package com.example.motosharing.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Locations extends Data{
    private StringProperty city;
    private StringProperty street;
    private StringProperty streetNumber;
    private ObservableList<Bike> bikeList= FXCollections.observableArrayList();

    public Locations(){
        this(null, null, null);
    }
    public Locations(String city, String street, String streetNumber){
        this.city= new SimpleStringProperty(city);
        this.street= new SimpleStringProperty(street);
        this.streetNumber= new SimpleStringProperty(streetNumber);
    }

    public String getCity(){
        return city.getValue();
    }
    public void setCity(String city){
        this.city.set(city);
    }
    public StringProperty getCityProperty(){
        return city;
    }

    public String getStreet(){
        return street.getValue();
    }
    public void setStreet(String street){
        this.street.set(street);
    }
    public StringProperty getStreetProperty(){
        return street;
    }

    public String getStreetNumber(){
        return streetNumber.getValue();
    }
    public void setStreetNumber(String streetNumber){
        this.streetNumber.set(streetNumber);
    }
    public StringProperty getStreetNumberProperty(){
        return streetNumber;
    }

    public ObservableList<Bike> getBikeList(){
        return bikeList;
    }
    public void addBike(Bike bike){
        bikeList.add(bike);
    }

}
