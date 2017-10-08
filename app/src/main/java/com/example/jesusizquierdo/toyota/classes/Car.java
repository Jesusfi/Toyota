package com.example.jesusizquierdo.toyota.classes;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class Car {
    String model;
    String configuration ;
    int color;
    String carPackage;


    public Car(String model, String configuration, int color, String carPackage) {
        this.model = model;
        this.configuration = configuration;
        this.color = color;
        this.carPackage = carPackage;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public String getConfiguration() {
        return configuration;
    }

    public int getColor() {
        return color;
    }

    public String getCarPackage() {
        return carPackage;
    }
}
