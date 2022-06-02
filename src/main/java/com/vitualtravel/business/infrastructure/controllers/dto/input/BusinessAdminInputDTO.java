package com.vitualtravel.business.infrastructure.controllers.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record BusinessAdminInputDTO (

    @NotNull(message = "user cannot be null")
    String user,

    @NotNull(message = "password cannot be null")
    String password,

    @NotNull(message = "telephone cannot be null")
    @Min(value = 600000000, message = "Must be a valid telephone")
    @Max(value = 799999999, message = "Must be a valid telephone")
    String tel,

    @NotNull(message = "email cannot be null")
    @Email
    String email
){}
