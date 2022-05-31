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

    @NotNull(message = "departure cannot be null")
    private DeparturesEnum departure;

    @NotNull(message = "arrival cannot be null")
    private ArrivalsEnum arrival;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "surname cannot be null")
    private String surname;

    @NotNull(message = "telphone cannot be null")
    @Min(value = 600000000, message = "Must be a valid telephone")
    @Max(value = 799999999, message = "Must be a valid telephone")
    private String tel;

    @NotNull(message = "email cannot be null")
    @Email(message = "Must be a valid email")
    private String email;

    @NotNull(message = "date cannot be null")
    private LocalDate date;

    @NotNull(message = "travelHour cannot be null")
    private DepartureHoursEnum travelHour;
}
