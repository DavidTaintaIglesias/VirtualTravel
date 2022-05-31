package com.vitualtravel.business.domain.entity;

//ENUM EN MAYUSCULAS PORQUE SON CONSTANTES
public enum BusinessArrivalsEnum {
    VALENCIA("VAL"),
    MADRID("MAD"),
    BARCELONA("BAR"),
    BILBAO("BIL");

    private String abreviature;

    BusinessArrivalsEnum(String abreviature){
        this.abreviature=abreviature;
    }

    public String getAbreviature(){
        return abreviature;
    }
}
