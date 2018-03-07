package com.example.h.customlist;

import java.io.Serializable;

/**
 * Created by h on 10/20/2017.
 */
public class China implements Serializable {
    private String population3= null;
    private String areachi= null;

    public China(String population3, String areachi) {
        this.population3 = population3;
        this.areachi= areachi;

    }

    public String getPopulation3() {
        return population3;
    }

    public void setPopulation3(String population3) {
        this.population3 = population3;
    }

    public String getAreachi() {
        return areachi;
    }

    public void setAreachi(String areachi) {
        this.areachi= areachi;
    }
}

