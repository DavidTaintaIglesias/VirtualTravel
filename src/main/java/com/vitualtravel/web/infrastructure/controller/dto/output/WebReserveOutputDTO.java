package com.vitualtravel.web.infrastructure.controller.dto.output;

import com.vitualtravel.web.domain.entity.WebReserve;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class WebReserveOutputDTO {

    private int id;
    private String travel;
    private String departureHour;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private LocalDate date;

    public WebReserveOutputDTO(WebReserve reserve){

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
