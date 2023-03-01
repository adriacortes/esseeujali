package com.adria.esseeujali.model;

import com.adria.esseeujali.tipoenum.GeneroEnum;

public class Trofeu {
    private String genero;
    private int total;

    public Trofeu() {}
    public Trofeu(String genero, int total) {
        this.genero = genero;
        this.total = total;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}