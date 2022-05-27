package com.vitualtravel.web.domain.entity;

public enum DeparturesEnum {
    VITORIA("VIT");

    private String abreviature;

    DeparturesEnum(String abreviature){
        this.abreviature=abreviature;
    }

    public String getAbreviature(){
        return abreviature;
    }
}
