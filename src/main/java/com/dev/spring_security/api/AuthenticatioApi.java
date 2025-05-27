package com.dev.spring_security.api;

import com.dev.spring_security.dtos.AuthenticationDto;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = {"Authenticaton"})
@RequestMapping("/v1/auth")
public interface AuthenticatioApi {

    @PostMapping(value = "/login")
    ResponseEntity Login(@RequestBody @Valid AuthenticationDto authenticationDto);
}
