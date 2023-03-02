package com.adria.esseeujali.model;


import com.adria.esseeujali.tipoenum.GeneroEnum;

import java.util.Objects;

public class Trofeu {
    private String genero;


    public Trofeu() {
    }

    public Trofeu(String genero) {
        this.genero = genero;

    }

    public Trofeu(GeneroEnum generoEnum) {
        this.genero = generoEnum.getDescricao();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trofeu trofeu = (Trofeu) o;
        return Objects.equals(genero, trofeu.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero);
    }
}