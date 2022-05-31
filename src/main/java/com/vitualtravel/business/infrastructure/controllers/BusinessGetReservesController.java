package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.service.BusinessGetReservesService;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Admin")
public class BusinessGetReservesController {

    @Autowired
    BusinessGetReservesService getReservesService;

    @GetMapping("/getAllReserves")
    public ResponseEntity<List<BusinessReserveOutputDTO>> getReserves() {

        return new ResponseEntity<>(getReservesService.getAllReserves().stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
    }

    @GetMapping("/getReservesByTrip")
    public ResponseEntity<List<BusinessReserveOutputDTO>> getReservesByTrip(@RequestParam(required = false) String arrival, @RequestParam(required = false) String travelHour) {

        if(travelHour==null){

            return new ResponseEntity<>(getReservesService.getReservesByArrival(arrival).stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
        }

        if(arrival==null){

            return new ResponseEntity<>(getReservesService.getReservesByTravelHour(travelHour).stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
        }

        return new ResponseEntity<>(getReservesService.getReservesByTrip(arrival, travelHour).stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
    }
}
