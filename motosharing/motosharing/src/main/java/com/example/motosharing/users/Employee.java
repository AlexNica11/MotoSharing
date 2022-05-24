package com.example.motosharing.users;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends User{
    private StringProperty rank;

    private IntegerProperty employeePassword;

    public Employee(){
        this(null, null, null, null);
    }

    public Employee(String name, Integer password, String rank, Integer employeePassword){
        this.name= new SimpleStringProperty(name);
        this.password= new SimpleIntegerProperty(password);
        this.rank= new SimpleStringProperty(rank);
        this.employeePassword= new SimpleIntegerProperty(employeePassword);
    }

    public String getRank(){
        return rank.getValue();
    }
    public void setRank(String rank){
        this.rank.set(rank);
    }
    public StringProperty getRankProperty(){
        return rank;
    }

    public Integer getEmployeePassword(){
        return employeePassword.getValue();
    }
}
