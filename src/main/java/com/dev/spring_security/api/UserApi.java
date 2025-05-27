package com.dev.spring_security.api;

import com.dev.spring_security.dtos.UseRecordDto;
import com.dev.spring_security.model.UsersModel;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = {"Users"})
@RequestMapping("/v1/user")
public interface UserApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    UsersModel insert(@RequestBody @Valid UseRecordDto useRecordDto);

}
