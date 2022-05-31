package com.vitualtravel.web.infrastructure.controller;

import com.vitualtravel.web.application.services.WebCreateReserveService;
import com.vitualtravel.web.infrastructure.controller.dto.input.WebReserveInputDTO;
import com.vitualtravel.web.infrastructure.controller.dto.output.WebReserveOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "Web")
public class WebCreateReserveControler {

    @Autowired
    WebCreateReserveService createReserveService;

    @PostMapping("/webReserve")
    public void postReserve (@Valid @RequestBody WebReserveInputDTO reserveInputDTO){

        //if(bindingResult.hasErrors()){ -> Clase BindingResult
        //Esta funcion comprueba si hay errores en mi codigo
        //En caso de ser true ejecuta el codigo, si no hay errores continua con el código
    }
}
