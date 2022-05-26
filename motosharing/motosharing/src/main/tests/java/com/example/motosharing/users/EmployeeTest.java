package com.example.motosharing.users;

import com.example.motosharing.data.Bike;
import com.example.motosharing.data.Locations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee emp;

    @BeforeEach
    void setUp(){
        emp= new Employee("name", "password".hashCode(), "rank", "employeePassword".hashCode());
    }

    @Test
    @DisplayName("Check if the name text is got")
    void getUsername(){
        assertEquals("name", emp.getName(), "The name text has to be shown");
    }

    @Test
    @DisplayName("Name has to be set")
    void setUsername(){
        emp.setName("Vasile");
        assertEquals("Vasile", emp.getName(), "The Vasile text has to be shown");
    }

    @Test
    @DisplayName("Password has to be set")
    void setPassword(){
        emp.setPassword("cartofi".hashCode());
        assertEquals("cartofi".hashCode(), emp.getPassword(), "The hashcode for the password has to be shown");
    }

    @Test
    @DisplayName("Check if the password is got")
    void getPassword(){
        assertEquals("password".hashCode(), emp.getPassword(), "The hashcode for the password has to be shown");
    }

    @Test
    @DisplayName("Check if the rank text is got")
    void getRank() {
        assertEquals("rank", emp.getRank(), "The rank text has to be shown");
    }

    @Test
    @DisplayName("Rank has to be set")
    void setRank() {
        emp.setRank("major general");
        assertEquals("major general", emp.getRank(), "The major general text has to be shown");
    }

    @Test
    @DisplayName("Check if the rank property is got")
    void getRankProperty() {
        assertEquals("rank", emp.getRankProperty().get(), "The rank text has to be shown");
    }

    @Test
    @DisplayName("Check if the employeePassword is got")
    void getEmployeePassword() {
        assertEquals("employeePassword".hashCode(), emp.getEmployeePassword(), "The hashcode for the employeePassword has to be shown");
    }
}