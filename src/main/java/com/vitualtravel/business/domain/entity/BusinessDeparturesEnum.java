package com.vitualtravel.business.domain.entity;

public enum BusinessDeparturesEnum {
    VITORIA("VIT");

    private String abreviature;

    BusinessDeparturesEnum(String abreviature){
        this.abreviature=abreviature;
    }

    public String getAbreviature(){
        return abreviature;
    }
}
