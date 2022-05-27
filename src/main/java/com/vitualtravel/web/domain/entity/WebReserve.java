package com.vitualtravel.web.domain.entity;

import com.vitualtravel.web.infrastructure.controller.dto.input.WebReserveInputDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Web_Reserves")
@Setter
@Getter
@NoArgsConstructor
public class WebReserve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    Integer id;

    @Column(name = "departure_city")
    String departure;

    @Column(name = "arrival_city")
    String arrival;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "telephone")
    String tel;

    @Column(name = "email")
    String email;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "travel_hour")
    String travelHour;

    public WebReserve(WebReserveInputDTO reserveInputDTO){

        //Cuidado la excepcion de los enums
        setDeparture(reserveInputDTO.getDeparture().getAbreviature());
        setArrival(reserveInputDTO.getArrival().getAbreviature());
        setName(reserveInputDTO.getName());
        setSurname(reserveInputDTO.getSurname());
        setTel(reserveInputDTO.getTel());
        setEmail(reserveInputDTO.getEmail());
        setDate(reserveInputDTO.getDate());
        setTravelHour(reserveInputDTO.getTravelHour().getHours());
    }
}
