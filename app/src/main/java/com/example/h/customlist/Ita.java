package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/20/2017.
 */
public class Ita implements Serializable {
    private String population8= null;
    private String areaita= null;

    public Ita(String population8, String areaita) {
        this.population8 = population8;
        this.areaita= areaita;

    }

    public String getPopulation8() {
        return population8;
    }

    public void setPopulation8(String population8) {
        this.population8 = population8;
    }

    public String getAreaita() {
        return areaita;
    }

    public void setAreaita(String areaita) {
        this.areaita = areaita;
    }
}
