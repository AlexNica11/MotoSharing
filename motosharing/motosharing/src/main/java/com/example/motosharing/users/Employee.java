package com.example.motosharing.users;

public class Employee extends User{
    private String rank;

    private String employeePassword;

    public Employee(){
        this(null, null, null, null);
    }

    public Employee(String name, String password, String rank, String employeePassword){
        this.name= name;
        this.password= password;
        this.rank= rank;
        this.employeePassword= employeePassword;
    }

    public String getRank(){
        return rank;
    }
    public void setRank(String rank){
        this.rank=rank;
    }

    public String getEmployeePassword(){
        return employeePassword;
    }
}
