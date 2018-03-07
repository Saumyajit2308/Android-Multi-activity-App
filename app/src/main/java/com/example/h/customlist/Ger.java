package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/20/2017.
 */
public class Ger implements Serializable {
    private String population5= null;
    private String areager= null;

    public Ger(String population5, String areager) {
        this.population5 = population5;
        this.areager= areager;

    }

    public String getPopulation5() {
        return population5;
    }

    public void setPopulation5(String population5) {
        this.population5 = population5;
    }

    public String getAreager() {
        return areager;
    }

    public void setAreager(String areager) {
        this.areager = areager;
    }
}