package com.vitualtravel.web.domain.entity;

public enum DepartureHoursEnum {
    FIRST("08:00"),
    SECOND("12:00"),
    THIRTH("16:00"),
    FOURTH("20:00");

    private String hours;

    DepartureHoursEnum(String hours) {
        this.hours=hours;
    }

    public String getHours(){
        return hours;}
}
