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
        bike.setLocation(new Locations("city", "street", "streetNumber"));
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
        assertEquals("man11", bike.getManufacturerProperty().get(), "The man11 text has to be shown");
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
        assertEquals("city", bike.getLocation().getCity(), "The city text has to be shown");
        assertEquals("street", bike.getLocation().getStreet(), "The street text has to be shown");
        assertEquals("streetNumber", bike.getLocation().getStreetNumber(), "The streetNumber text has to be shown");
    }

    @Test
    @DisplayName("Check if location has been set")
    void setLocation() {
        bike.setLocation(new Locations("Monaco", "Chimps", "221"));
        assertEquals("Monaco", bike.getLocation().getCity(), "The Monaco text has to be shown");
        assertEquals("Chimps", bike.getLocation().getStreet(), "The Chimps text has to be shown");
        assertEquals("221", bike.getLocation().getStreetNumber(), "The 221 text has to be shown");
    }
}