package com.example.motosharing.users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer extends User{
    private StringProperty email;
    private String dateOfBirth;
    private int creditCard;
    private String cardOwner;
    private String expirationDate;
    private int securityCode;
    private String review;

    public Customer(){
        this(null, null);
    }

    public Customer(String username, String password){
        name= new SimpleStringProperty(username);
        this.password= new SimpleStringProperty(password);
        email= new SimpleStringProperty("email");
        dateOfBirth="date";
        creditCard=1112111;
        cardOwner="owner";
        expirationDate="expiration";
        securityCode=2221222;
    }

    public void setEmail(String email){
        this.email.set(email);
    }
    public String getEmail(){
        return email.getValue();
    }
    public StringProperty getEmailProperty(){
        return email;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public int getCreditCard(){
        return creditCard;
    }
    public void setCreditCard(int creditCard){
        this.creditCard=creditCard;
    }

    public String getCardOwner(){
        return cardOwner;
    }
    public void setCardOwner(String cardOwner){
        this.cardOwner=cardOwner;
    }

    public String getExpirationDate(){
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate=expirationDate;
    }

    public int getSecurityCode(){
        return securityCode;
    }
    public void setSecurityCode(int securityCode){
        this.securityCode=securityCode;
    }

    public void setReview(String review){
        this.review= review;
    }
    public String getReview(){
        return review;
    }
}
