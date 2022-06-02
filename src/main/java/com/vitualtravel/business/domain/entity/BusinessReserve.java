package com.vitualtravel.business.domain.entity;

import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessReserveInputDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Business_Reserves")
@Setter
@Getter
@NoArgsConstructor
public class BusinessReserve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    Integer id;

    @Column(name = "origin_city")
    String departure;

    @Column(name = "destination_city")
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

    public BusinessReserve (BusinessReserveInputDTO businessReserveInputDTO) {

        setDeparture(businessReserveInputDTO.departure().toString());
        setArrival(businessReserveInputDTO.arrival().toString());
        setName(businessReserveInputDTO.name());
        setSurname(businessReserveInputDTO.surname());
        setTel(businessReserveInputDTO.tel());
        setEmail(businessReserveInputDTO.email());
        setDate(businessReserveInputDTO.date());
        setTravelHour(businessReserveInputDTO.travelHour().getHours());

    }

}
