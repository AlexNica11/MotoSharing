package com.example.motosharing.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {

    Bike bike;

    @BeforeEach
    void setUp(){
        bike= new Bike();
    }

    @Test
    @DisplayName("Check if the manufacturer text is got")
    void getManufacturer() {
        bike.setManufacturer("manufacturer");
        assertEquals("manufacturer", bike.getManufacturer(), "The manufacturer text has to be shown");
    }

    @Test
    @DisplayName("Manufacturer has to be set")
    void setManufacturer() {
        bike= new Bike("man11", "model", "color", "engineSize");
        bike.setManufacturer("manufacturer");
        assertEquals("manufacturer", bike.getManufacturer(), "The manufacturer text has to be shown");
    }

    @Test
    @DisplayName("Check if manufacturer property is got")
    void getManufacturerProperty() {

    }

    @Test
    void getModel() {
    }

    @Test
    void setModel() {
    }

    @Test
    void getModelProperty() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void getColorProperty() {
    }

    @Test
    void getEngineSize() {
    }

    @Test
    void setEngineSize() {
    }

    @Test
    void getEngineSizeProperty() {
    }

    @Test
    void getLocation() {
    }

    @Test
    void setLocation() {
    }
}