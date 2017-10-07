package com.example.jesusizquierdo.toyota.classes;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class SimpleProfile {
    String email ;
    String uniqueID;

    public SimpleProfile(String email, String uniqueID) {
        this.email = email;
        this.uniqueID = uniqueID;
    }

    public SimpleProfile() {
    }

    public String getEmail() {
        return email;
    }

    public String getUniqueID() {
        return uniqueID;
    }
}
