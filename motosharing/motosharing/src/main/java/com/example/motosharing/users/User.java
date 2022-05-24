package com.example.motosharing.users;

import com.example.motosharing.data.Data;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class User extends Data {
    protected StringProperty name;
    protected IntegerProperty password;

    public String getName(){
        return name.getValue();
    }
    public void setName(String name){
        this.name.set(name);
    }
    public StringProperty getNameProperty(){
        return name;
    }

    public Integer getPassword(){
        return password.getValue();
    }
    public void setPassword(Integer password){
        this.password.set(password);
    }
}
