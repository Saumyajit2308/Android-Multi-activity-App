package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/20/2017.
 */
public class Ind implements Serializable {
    private String population6= null;
    private String areaind= null;

    public Ind(String population6, String areaind) {
        this.population6 = population6;
        this.areaind= areaind;

    }

    public String getPopulation6() {
        return population6;
    }

    public void setPopulation6(String population6) {
        this.population6 = population6;
    }

    public String getAreaind() {
        return areaind;
    }

    public void setAreaind(String areaind) {
        this.areaind = areaind;
    }
}