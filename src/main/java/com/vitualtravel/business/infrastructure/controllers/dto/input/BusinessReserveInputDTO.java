package com.vitualtravel.business.infrastructure.controllers.dto.input;

import com.vitualtravel.business.domain.entity.BusinessArrivalsEnum;
import com.vitualtravel.business.domain.entity.BusinessDepartureHoursEnum;
import com.vitualtravel.business.domain.entity.BusinessDeparturesEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BusinessReserveInputDTO {

    @NotNull(message = "departure cannot be null")
    private BusinessDeparturesEnum departure;

    @NotNull(message = "arrival cannot be null")
    private BusinessArrivalsEnum arrival;

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
    private BusinessDepartureHoursEnum travelHour;
}
