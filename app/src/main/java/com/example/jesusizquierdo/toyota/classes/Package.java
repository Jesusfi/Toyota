package com.example.jesusizquierdo.toyota.classes;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class Package {
    String name;
    String price;
    String description;

    public Package(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
