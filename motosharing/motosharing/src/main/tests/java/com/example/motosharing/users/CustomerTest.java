package com.example.motosharing.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer cus;

    @BeforeEach
    void setUp(){
        cus= new Customer("name", "password".hashCode());
        cus.setEmail("email");
        cus.setReview("review");
        cus.setSecurityCode(1000);
        cus.setExpirationDate("01.01.2000");
        cus.setCardOwner("owner");
        cus.setCreditCard(1222);
        cus.setDateOfBirth("01.01.2000");
    }

    @Test
    @DisplayName("Check if the name text is got")
    void getUsername(){
        assertEquals("name", cus.getName(), "The name text has to be shown");
    }

    @Test
    @DisplayName("Name has to be set")
    void setUsername(){
        cus.setName("Vasile");
        assertEquals("Vasile", cus.getName(), "The Vasile text has to be shown");
    }

    @Test
    @DisplayName("Password has to be set")
    void setPassword(){
        cus.setPassword("cartofi".hashCode());
        assertEquals("cartofi".hashCode(), cus.getPassword(), "The hashcode for the password has to be shown");
    }

    @Test
    @DisplayName("Check if the password is got")
    void getPassword(){
        assertEquals("password".hashCode(), cus.getPassword(), "The hashcode for the password has to be shown");
    }

    @Test
    @DisplayName("Email has to be set")
    void setEmail() {
        cus.setEmail("gigi@gmail.com");
        assertEquals("gigi@gmail.com", cus.getEmail(), "The gigi@gmail.com text has to be shown");
    }

    @Test
    @DisplayName("Check if the email text is got")
    void getEmail() {
        assertEquals("email", cus.getEmail(), "The email text has to be shown");
    }

    @Test
    @DisplayName("Check if the email property text is got")
    void getEmailProperty() {
        assertEquals("email", cus.getEmailProperty().get(), "The email text has to be shown");
    }

    @Test
    @DisplayName("Check if the dateOfBirth text is got")
    void getDateOfBirth() {
        assertEquals("01.01.2000", cus.getDateOfBirth(), "The 01.01.2001 text has to be shown");
    }

    @Test
    @DisplayName("DateOfBirth has to be set")
    void setDateOfBirth() {
        cus.setDateOfBirth("11.11.2020");
        assertEquals("11.11.2020", cus.getDateOfBirth(), "The 11.11.2020 text has to be shown");
    }

    @Test
    @DisplayName("Check if the creditCardNr text is got")
    void getCreditCard() {
        assertEquals(1222, cus.getCreditCard() ,"The 1222 text has to be shown");
    }

    @Test
    @DisplayName("CreditCardNr has to be set")
    void setCreditCard() {
        cus.setCreditCard(3434);
        assertEquals(3434, cus.getCreditCard() ,"The 3434 text has to be shown");
    }

    @Test
    @DisplayName("Check if the cardOwner text is got")
    void getCardOwner() {
        assertEquals("owner", cus.getCardOwner() ,"The owner text has to be shown");
    }

    @Test
    @DisplayName("CardOwner has to be set")
    void setCardOwner() {
        cus.setCardOwner("Virgil Pop");
        assertEquals("Virgil Pop", cus.getCardOwner() ,"The Virgil Pop text has to be shown");
    }

    @Test
    @DisplayName("Check if the expirationDate is got")
    void getExpirationDate() {
        assertEquals("01.01.2000", cus.getExpirationDate() ,"The 01.01.2000 text has to be shown");
    }

    @Test
    @DisplayName("ExpirationDate has to be set")
    void setExpirationDate() {
        cus.setExpirationDate("21.12.2024");
        assertEquals("21.12.2024", cus.getExpirationDate(),"The 21.12.2024 text has to be shown");
    }

    @Test
    @DisplayName("Check if the securityCode is got")
    void getSecurityCode() {
        assertEquals(1000, cus.getSecurityCode() ,"The 1000 text has to be shown");
    }

    @Test
    @DisplayName("SecurityCode has to be set")
    void setSecurityCode() {
        cus.setSecurityCode(305);
        assertEquals(305, cus.getSecurityCode() ,"The 305 text has to be shown");
    }

    @Test
    @DisplayName("Review has to be set")
    void setReview() {
        cus.setReview("best");
        assertEquals("best", cus.getReview() ,"The best text has to be shown");
    }

    @Test
    @DisplayName("Check if the review text is got")
    void getReview() {
        assertEquals("review", cus.getReview() ,"The review text has to be shown");
    }
}