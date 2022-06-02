package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.service.BusinessGetReservesService;
import com.vitualtravel.business.domain.entity.BusinessDepartureHoursEnum;
import com.vitualtravel.business.infrastructure.controllers.dto.output.BusinessReserveOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

    @GetMapping("/getFilteredReserves")
    public ResponseEntity<List<BusinessReserveOutputDTO>> getFilteredReserves(@RequestParam(required = false) String minDate,
                                                                              @RequestParam(required = false) String maxDate,
                                                                              @RequestParam(required = false) String hourMin,
                                                                              @RequestParam(required = false) String hourMax) {

        return new ResponseEntity<>(getReservesService.getFilteredReserves(minDate, maxDate, hourMin, hourMax).stream().map(BusinessReserveOutputDTO::new).toList(), HttpStatus.OK);
    }
}
