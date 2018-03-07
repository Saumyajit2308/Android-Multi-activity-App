package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/20/2017.
 */
public class Irl implements Serializable {
    private String population7= null;
    private String areairl= null;

    public Irl(String population7, String areairl) {
        this.population7 = population7;
        this.areairl= areairl;

    }

    public String getPopulation7() {
        return population7;
    }

    public void setPopulation7(String population7) {
        this.population7 = population7;
    }

    public String getAreairl() {
        return areairl;
    }

    public void setAreairl(String areairl) {
        this.areairl = areairl;
    }
}