package com.adria.esseeujali.model;


import com.adria.esseeujali.tipoenum.GeneroEnum;

import java.util.Objects;

public class Trofeu {
    private String genero;
    private int total;

    public Trofeu() {
    }

    public Trofeu(String genero, int total) {
        this.genero = genero;
        this.total = total;
    }

    public Trofeu(GeneroEnum generoEnum, int total) {
        this.genero = generoEnum.getDescricao();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trofeu trofeu = (Trofeu) o;
        return total == trofeu.total && Objects.equals(genero, trofeu.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero, total);
    }

    @Override
    public String toString() {
        return "Trofeu{" +
                "genero='" + genero + '\'' +
                ", total=" + total +
                '}';
    }
}