package com.vitualtravel.web.infrastructure.controller.dto.input;

import com.vitualtravel.web.domain.entity.ArrivalsEnum;
import com.vitualtravel.web.domain.entity.DeparturesEnum;
import com.vitualtravel.web.domain.entity.DepartureHoursEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class WebReserveInputDTO {

    @NotNull
    private DeparturesEnum departure;

    @NotNull
    private ArrivalsEnum arrival;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Min(value = 600000000, message = "Must be a valid telephone")
    @Max(value = 799999999, message = "Must be a valid telephone")
    private String tel;

    @NotNull
    @Email
    private String email;

    @NotNull
    private LocalDate date;

    @NotNull
    private DepartureHoursEnum travelHour;
}
