package com.example.jesusizquierdo.toyota.classes;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class SimpleProfile {
    String email ;
    String uniqueID;
    String name;

    public SimpleProfile(String email, String uniqueID,String name) {
        this.email = email;
        this.uniqueID = uniqueID;
        this.name = name;
    }

    public SimpleProfile() {
    }

    public String getEmail() {
        return email;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }
}
