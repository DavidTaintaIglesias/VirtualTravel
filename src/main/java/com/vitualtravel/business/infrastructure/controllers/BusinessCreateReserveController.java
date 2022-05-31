package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.service.BusinessCreateReserveService;
import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessReserveInputDTO;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v0")
@Api(tags = "Business")
public class BusinessCreateReserveController {

    @Autowired
    BusinessCreateReserveService businessCreateReserveService;

    @PostMapping("/businessReserve")
    public ResponseEntity<BusinessReserveOutputDTO> createReserve (@Valid @RequestBody BusinessReserveInputDTO reserveInput) {

        return new ResponseEntity<>(new BusinessReserveOutputDTO(businessCreateReserveService.createReserve(reserveInput)), HttpStatus.CREATED);
    }


}
