package com.vitualtravel.web.domain.entity;

//ENUM EN MAYUSCULAS PORQUE SON CONSTANTES
public enum ArrivalsEnum {
    VALENCIA("VAL"),
    MADRID("MAD"),
    BARCELONA("BAR"),
    BILBAO("BIL");

    private String abreviature;

    ArrivalsEnum(String abreviature){
        this.abreviature=abreviature;
    }

    public String getAbreviature(){
        return abreviature;
    }
}
