package com.dev.spring_security.dtos;

import com.dev.spring_security.enums.UserRole;

public record UseRecordDto(String login, String password, UserRole role) {
}
