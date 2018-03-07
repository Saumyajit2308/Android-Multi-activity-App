package com.example.h.customlist;
import java.io.Serializable;
public class Aus implements Serializable{
    private String population= null;
    private String areaaus= null;

    public Aus(String population, String areaaus) {
        this.population = population;
        this.areaaus= areaaus;

    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaaus() {
        return areaaus;
    }

    public void setAreaaus(String areaaus) {
        this.areaaus = areaaus;
    }
}
