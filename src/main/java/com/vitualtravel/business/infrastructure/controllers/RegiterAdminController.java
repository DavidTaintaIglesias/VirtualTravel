package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.RegisterAdminService;
import com.vitualtravel.business.infrastructure.controllers.dto.input.AdminInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.AdminOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "Business")
public class RegiterAdminController {

    @Autowired
    RegisterAdminService registerAdminService;

    @PostMapping("/register")
    public ResponseEntity<AdminOutputDTO> registerAdmin(@Valid @RequestBody AdminInputDTO adminInputDTO) {

        return new ResponseEntity<>(registerAdminService.registerAdmin(adminInputDTO), HttpStatus.CREATED);
    }
}
