package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/19/2017.
 */
public class Braz implements Serializable {
    private String population2= null;
    private String areabraz= null;

    public Braz(String population2, String areabraz) {
        this.population2 = population2;
        this.areabraz= areabraz;

    }

    public String getPopulation2() {
        return population2;
    }

    public void setPopulation2(String population2) {
        this.population2 = population2;
    }

    public String getAreabraz() {
        return areabraz;
    }

    public void setAreabraz(String areabraz) {
        this.areabraz = areabraz;
    }
}
