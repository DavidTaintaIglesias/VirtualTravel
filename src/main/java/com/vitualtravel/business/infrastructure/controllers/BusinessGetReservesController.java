package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.service.BusinessGetReservesService;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0")
@Api(tags = "Admin")
public class BusinessGetReservesController {

    @Autowired
    BusinessGetReservesService getReservesService;

    @GetMapping("/getAllReserves")
    public ResponseEntity<List<BusinessReserveOutputDTO>> getReserves() {

        return new ResponseEntity<>(getReservesService.getAllReserves().stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
    }

    @GetMapping("/getFilteredReserves/{departure}/{arrival}")
    public ResponseEntity<List<BusinessReserveOutputDTO>> getFilteredReserves(@PathVariable String arrival,
                                                                              @PathVariable String departure,
                                                                              @RequestParam(required = false) String minDate,
                                                                              @RequestParam(required = false) String maxDate,
                                                                              @RequestParam(required = false) String hourMin,
                                                                              @RequestParam(required = false) String hourMax) {

        return new ResponseEntity<>(getReservesService.getFilteredReserves(departure, arrival, minDate, maxDate, hourMin, hourMax).stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
    }
}
