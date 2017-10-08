package com.example.jesusizquierdo.toyota.classes;

/**
 * Created by Jesus Izquierdo on 10/7/2017.
 */

public class Engine {
    String Name;
    String info1;
    String info2;
    String info3;

    public Engine(String name, String info1, String info2, String info3) {
        Name = name;
        this.info1 = info1;
        this.info2 = info2;
        this.info3 = info3;
    }

    public String getName() {
        return Name;
    }

    public String getInfo1() {
        return info1;
    }

    public String getInfo2() {
        return info2;
    }

    public String getInfo3() {
        return info3;
    }
}
