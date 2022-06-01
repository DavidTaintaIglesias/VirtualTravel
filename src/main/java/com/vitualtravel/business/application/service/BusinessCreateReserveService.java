package com.vitualtravel.business.application.service;

import com.vitualtravel.business.domain.entity.BusinessReserve;
import com.vitualtravel.business.infrastructure.controllers.dto.input.BusinessReserveInputDTO;
import com.vitualtravel.business.infrastructure.repository.BusinessReserveRepository;
import com.vitualtravel.shared.exceptions.Unprocessable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BusinessCreateReserveService {

    @Autowired
    BusinessReserveRepository repository;

//    @Autowired
//    private JavaMailSender javaMailSender;

    @Value("${maxPersonOnBus}")
    int numberSits;

    public BusinessReserve createReserve(BusinessReserveInputDTO businessReserveInputDTO) {

        //Añadir limitacion de asientos por trayecto
        BusinessReserve businessReserve = new BusinessReserve(businessReserveInputDTO);

        if(repository.findByArrivalAndTravelHour(businessReserve.getArrival(), businessReserve.getTravelHour()).stream().count()==numberSits){
            throw new Unprocessable("Sorry, bus completed");
        }

        repository.save(businessReserve);

//        String mailReserve = "Su reserva para el viaje "+businessReserve.getDeparture()+"-"+businessReserve.getArrival()
//                +" a las: "+businessReserve.getTravelHour()+" se ha realizado con exito.\nSu Id de reserva es: "+businessReserve.getId();
//        sendMail(businessReserve.getEmail(), mailReserve);

        return businessReserve;
    }

//    public void sendMail(String to, String body) {
//
//        SimpleMailMessage email = new SimpleMailMessage();
//
//        email.setTo(to);
//        email.setText(body);
//
//        javaMailSender.send(email);
//    }
}
