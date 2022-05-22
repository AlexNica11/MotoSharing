package com.example.motosharing.users;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends User{
    private StringProperty rank;

    private StringProperty employeePassword;

    public Employee(){
        this(null, null, null, null);
    }

    public Employee(String name, String password, String rank, String employeePassword){
        this.name= new SimpleStringProperty(name);
        this.password= new SimpleStringProperty(password);
        this.rank= new SimpleStringProperty(rank);
        this.employeePassword= new SimpleStringProperty(employeePassword);
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

    public String getEmployeePassword(){
        return employeePassword.getValue();
    }
}
