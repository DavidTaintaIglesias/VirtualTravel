package com.vitualtravel.business.infrastructure.controllers;

import com.vitualtravel.business.application.service.BusinessLoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "Admin")

public class BusinessLoginController {

    @Autowired
    BusinessLoginService loginService;

    //Endpoint para el login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam("password") String password){
        return new ResponseEntity<>(loginService.getLogin(user, password), HttpStatus.OK);
        }
}
