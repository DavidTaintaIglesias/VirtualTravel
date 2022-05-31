package com.vitualtravel.business.infrastructure.controllers.dto.output;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BusinessReserveOutputDTO {

    private int id;
    private String travel;
    private String departureHour;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private LocalDate date;

    public BusinessReserveOutputDTO(BusinessReserve reserve){

        setId(reserve.getId());
        setTravel(reserve.getDeparture() + " - " + reserve.getArrival());
        setDepartureHour(reserve.getTravelHour());
        setName(reserve.getName());
        setSurname(reserve.getSurname());
        setTel(reserve.getTel());
        setEmail(reserve.getEmail());
        setDate(reserve.getDate());
    }
}
