package com.vitualtravel.business.infrastructure.controllers.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class BusinessAdminInputDTO {

    @NotNull(message = "user cannot be null")
    private String user;

    @NotNull(message = "password cannot be null")
    private String password;

    @NotNull(message = "telephone cannot be null")
    @Min(value = 600000000, message = "Must be a valid telephone")
    @Max(value = 799999999, message = "Must be a valid telephone")
    private String tel;

    @NotNull(message = "email cannot be null")
    @Email
    private String email;
}
