package com.example.motosharing.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bike extends Data{
    private StringProperty manufacturer;
    private StringProperty model;
    private StringProperty color;
    private StringProperty engineSize;
    private Locations location;

    public Bike(){
        this(null, null, null, null);
    }
    public Bike(String manufacturer, String model, String color, String engineSize){
        this.manufacturer= new SimpleStringProperty(manufacturer);
        this.model= new SimpleStringProperty(model);
        this.color= new SimpleStringProperty(color);
        this.engineSize= new SimpleStringProperty(engineSize);
    }

    public String getManufacturer(){
        return manufacturer.getValue();
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer.set(manufacturer);
    }
    public StringProperty getManufacturerProperty(){
        return manufacturer;
    }

    public String getModel(){
        return model.getValue();
    }
    public void setModel(String model){
        this.model.set(model);
    }
    public StringProperty getModelProperty(){
        return model;
    }

    public String getColor(){
        return color.getValue();
    }
    public void setColor(String color){
        this.color.set(color);
    }
    public StringProperty getColorProperty(){
        return color;
    }

    public String getEngineSize(){
        return engineSize.getValue();
    }
    public void setEngineSize(String engineSize){
        this.engineSize.set(engineSize);
    }
    public StringProperty getEngineSizeProperty(){
        return engineSize;
    }

    public Locations getLocation(){
        return location;
    }
    public void setLocation(Locations location){
        this.location= location;
    }
}
