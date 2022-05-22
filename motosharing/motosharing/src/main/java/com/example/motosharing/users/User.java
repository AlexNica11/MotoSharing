package com.example.motosharing.users;

import com.example.motosharing.data.Data;
import javafx.beans.property.StringProperty;

public class User extends Data {
    protected StringProperty name;
    protected StringProperty password;

    public String getName(){
        return name.getValue();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public StringProperty getNameProperty(){
        return name;
    }

    public String getPassword(){
        return password.getValue();
    }
    public void setPassword(String password){
        this.password.set(password);
    }
}
