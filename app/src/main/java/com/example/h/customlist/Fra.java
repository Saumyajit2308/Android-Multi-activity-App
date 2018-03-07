package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/20/2017.
 */
public class Fra implements Serializable {
    private String population4= null;
    private String areafra= null;

    public Fra(String population4, String areafra) {
        this.population4 = population4;
        this.areafra= areafra;

    }

    public String getPopulation4() {
        return population4;
    }

    public void setPopulation4(String population4) {
        this.population4 = population4;
    }

    public String getAreafra() {
        return areafra;
    }

    public void setAreafra(String areafra) {
        this.areafra = areafra;
    }
}

