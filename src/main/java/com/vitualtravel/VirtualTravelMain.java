package com.vitualtravel;

import com.vitualtravel.business.application.service.BusinessJWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
@EnableWebSecurity
public class VirtualTravelMain extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(VirtualTravelMain.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.addFilterAfter(new BusinessJWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers("/register","/getReserves").hasRole("ADMIN")//IMPORTANTE!! Nombre del rol sin ROLE_
				.antMatchers(HttpMethod.GET).permitAll()
				.antMatchers(HttpMethod.POST).permitAll()
				.anyRequest().authenticated();
	}
}
