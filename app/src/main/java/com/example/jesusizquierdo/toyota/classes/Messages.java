package com.example.jesusizquierdo.toyota.classes;

/**
 * Created by Jesus Izquierdo on 10/8/2017.
 */

public class Messages {
    String sender;
    String message;

    public Messages(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}
