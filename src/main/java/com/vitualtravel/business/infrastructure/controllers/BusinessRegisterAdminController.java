package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.BusinessRegisterAdminService;
import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessAdminInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessAdminOutputDTO;
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
public class BusinessRegisterAdminController {

    @Autowired
    BusinessRegisterAdminService registerAdminService;

    @PostMapping("/register")
    public ResponseEntity<BusinessAdminOutputDTO> registerAdmin(@Valid @RequestBody BusinessAdminInputDTO adminInputDTO) {

        return new ResponseEntity<>(registerAdminService.registerAdmin(adminInputDTO), HttpStatus.CREATED);
    }
}
