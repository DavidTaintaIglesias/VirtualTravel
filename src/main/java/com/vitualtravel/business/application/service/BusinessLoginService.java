package com.vitualtravel.business.application.service;

import com.vitualtravel.business.domain.entity.BusinessAdmin;
import com.vitualtravel.business.infrastructure.repository.BusinessAdminRepository;
import com.vitualtravel.shared.exceptions.NotFound;
import com.vitualtravel.shared.exceptions.Unprocessable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessLoginService {

    @Autowired
    BusinessAdminRepository repository;

    //Verificaciones para el login
    public String getLogin(String user, String pass){

        BusinessAdmin admin = repository.findByUser(user).orElseThrow(()-> new NotFound("User not found"));

        String password = admin.getPassword();

        if(!pass.equals(password)){
            throw new Unprocessable("Wrong password");
        }

        String rol = "ROLE_ADMIN";//Puedo poner tantos roles como necesite. Poner siempre ROLE_ delante del nombre del rol
        return getJWTToken(user, rol);
    }

    //Generacion del token
    private String getJWTToken(String user, String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(user)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
