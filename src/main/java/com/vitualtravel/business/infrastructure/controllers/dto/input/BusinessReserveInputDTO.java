package com.vitualtravel.business.infrastructure.controllers.dto.input;

import com.vitualtravel.business.domain.entity.BusinessArrivalsEnum;
import com.vitualtravel.business.domain.entity.BusinessDepartureHoursEnum;
import com.vitualtravel.business.domain.entity.BusinessDeparturesEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record BusinessReserveInputDTO(

    @NotNull(message = "departure cannot be null")
    BusinessDeparturesEnum departure,

    @NotNull(message = "arrival cannot be null")
    BusinessArrivalsEnum arrival,

    @NotNull(message = "name cannot be null")
    String name,

    @NotNull(message = "surname cannot be null")
    String surname,

    @NotNull(message = "telphone cannot be null")
    @Min(value = 600000000, message = "Must be a valid telephone")
    @Max(value = 799999999, message = "Must be a valid telephone")
    String tel,

    @NotNull(message = "email cannot be null")
    @Email(message = "Must be a valid email")
    String email,

    @NotNull(message = "date cannot be null")
    LocalDate date,

    @NotNull(message = "travelHour cannot be null")
    BusinessDepartureHoursEnum travelHour
){}
