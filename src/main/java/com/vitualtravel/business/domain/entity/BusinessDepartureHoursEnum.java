package com.vitualtravel.business.domain.entity;

public enum BusinessDepartureHoursEnum {
    FIRST("08:00"),
    SECOND("12:00"),
    THIRTH("16:00"),
    LAST("20:00");

    private String hours;

    BusinessDepartureHoursEnum(String hours) {
        this.hours=hours;
    }

    public String getHours(){
        return hours;}
}
