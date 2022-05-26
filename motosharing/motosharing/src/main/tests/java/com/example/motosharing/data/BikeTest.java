package com.example.motosharing.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {

    Bike bike;

    @BeforeEach
    void setUp(){
        bike= new Bike("man11", "model", "color", "engineSize");
        bike.setLocation(new Locations("city", "stret", "streetNumber"));
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
        bike.setManufacturer("manufacturer");
        assertEquals("manufacturer", bike.getManufacturer(), "The manufacturer text has to be shown");
    }

    @Test
    @DisplayName("Check if manufacturer property is got")
    void getManufacturerProperty() {
        assertEquals("manufacturer", bike.getManufacturerProperty().get(), "The manufacturer text has to be shown");
    }

    @Test
    @DisplayName("Check if model is got")
    void getModel() {
        assertEquals("model", bike.getModel(), "The model text has to be shown");
    }

    @Test
    @DisplayName("Check if model has been set")
    void setModel() {
        bike.setModel("fiesta");
        assertEquals("fiesta", bike.getModel(), "The fiesta text has to be shown");
    }

    @Test
    @DisplayName("Check if model property has been got")
    void getModelProperty() {
        assertEquals("model", bike.getModelProperty().get(), "The model text has to be shown");
    }

    @Test
    @DisplayName("Check if color is got")
    void getColor() {
        assertEquals("color", bike.getColor(), "The color text has to be shown");
    }

    @Test
    @DisplayName("Check if color has been set")
    void setColor() {
        bike.setColor("blue");
        assertEquals("blue", bike.getColor(), "The blue text has to be shown");
    }

    @Test
    @DisplayName("Check if color property has been got")
    void getColorProperty() {
        assertEquals("color", bike.getColorProperty().get(), "The color text has to be shown");
    }

    @Test
    @DisplayName("Check if engineSize is got")
    void getEngineSize() {
        assertEquals("engineSize", bike.getEngineSize(), "The engineSize text has to be shown");
    }

    @Test
    @DisplayName("Check if engineSize has been set")
    void setEngineSize() {
        bike.setEngineSize("1200");
        assertEquals("1200", bike.getEngineSize(), "The 1200 text has to be shown");
    }

    @Test
    @DisplayName("Check if engineSize property has been got")
    void getEngineSizeProperty() {
        assertEquals("engineSize", bike.getEngineSizeProperty().get(), "The engineSize text has to be shown");
    }

    @Test
    @DisplayName("Check if location is got")
    void getLocation() {
        assertEquals("city", bike.getLocation(), "The engineSize text has to be shown");
    }

    @Test
    void setLocation() {
    }
}