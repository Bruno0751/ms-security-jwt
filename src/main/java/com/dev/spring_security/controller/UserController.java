package com.dev.spring_security.controller;

import com.dev.spring_security.api.UserApi;
import com.dev.spring_security.dtos.UseRecordDto;
import com.dev.spring_security.model.UsersModel;
import com.dev.spring_security.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class UserController implements UserApi {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UsersModel insert(UseRecordDto useRecordDto) {
        if (this.usersRepository.findByLogin(useRecordDto.login()) != null) {
//            return ResponseEntity.badRequest().build();
            throw new IllegalArgumentException("Login já cadastrado.");
        }
        String encriptedPassword = new BCryptPasswordEncoder().encode(useRecordDto.password());
        UsersModel usersModel = new UsersModel(useRecordDto.login(), encriptedPassword, useRecordDto.role());
        return this.usersRepository.save(usersModel);
    }
}
