package com.example.miniproject;

import java.io.Serializable;

public class Establishment implements Serializable {
    private int estID;
    private String estName;
    private String estType;
    private String foodType;
    private String location;

    public Establishment(){}

    public Establishment(String estName,String estType,String foodType,String location){
        this.estName = estName;
        this.estType = estType;
        this.foodType = foodType;
        this.location = location;
    }

    public Establishment(int estID,String estName,String estType,String foodType,String location){
        this.estID = estID;
        this.estName = estName;
        this.estType = estType;
        this.foodType = foodType;
        this.location = location;
    }

    public int getEstID(){
        return estID;
    }

    public void setEstID(int estID) {
        this.estID = estID;
    }

    public String getEstName() {
        return estName;
    }

    public void setEstName(String estName) {
        this.estName = estName;
    }

    public String getEstType() {
        return estType;
    }

    public void setEstType(String estType) {
        this.estType = estType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString(){
        return  this.estName + " " +this.estType;
    }
}
