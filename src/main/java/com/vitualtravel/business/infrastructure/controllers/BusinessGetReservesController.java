package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.service.BusinessGetReservesService;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Admin")
public class BusinessGetReservesController {

    @Autowired
    BusinessGetReservesService getReservesService;

    @GetMapping("/getReserves")
    public ResponseEntity<List<BusinessReserveOutputDTO>> getReserves() {

        return new ResponseEntity<>(getReservesService.getReserves().stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
    }
}
