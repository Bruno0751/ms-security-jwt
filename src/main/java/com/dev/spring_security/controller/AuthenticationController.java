package com.dev.spring_security.controller;

import com.dev.spring_security.api.AuthenticatioApi;
import com.dev.spring_security.dtos.AuthenticationDto;
import com.dev.spring_security.dtos.LoginResponeDto;
import com.dev.spring_security.model.UsersModel;
import com.dev.spring_security.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class AuthenticationController implements AuthenticatioApi {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity Login(AuthenticationDto authenticationDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDto.login(), authenticationDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generationToken((UsersModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponeDto(token));
    }
}
