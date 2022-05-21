package com.example.motosharing.users;

public class Customer {
    private String email;
    private String password;
    private String name;
    private String dateOfBirth;
    private int creditCard;
    private String cardOwner;
    private String expirationDate;
    private int securityCode;

    public Customer(){
        this(null, null);
    }

    public Customer(String username, String password){
        name=username;
        this.password= password;
        email="email";
        dateOfBirth="date";
        creditCard=1112111;
        cardOwner="owner";
        expirationDate="expiration";
        securityCode=2221222;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
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
}
