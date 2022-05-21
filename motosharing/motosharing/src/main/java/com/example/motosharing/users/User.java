package com.example.motosharing.users;

public class User {
    protected String name;
    protected String password;

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
}
