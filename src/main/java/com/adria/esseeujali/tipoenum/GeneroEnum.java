package com.adria.esseeujali.tipoenum;

public enum GeneroEnum {
    LITERATURADEFICCAO("Literatura de ficção"),
    AUTOAJUDA("Autoa juda"),

    HISTORIAEMQUADRILHO("História em quadrinhos"),

    RELIGIAO("Religião");

    private String descricao;
    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }





}

