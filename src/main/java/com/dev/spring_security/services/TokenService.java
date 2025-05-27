package com.dev.spring_security.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.dev.spring_security.model.UsersModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generationToken(UsersModel usersModel) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);

            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usersModel.getLogin())
                    .withExpiresAt(getExpirationData())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generation token", e);

        }
    }

    public String valdadeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);

        try {
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {
            return "";
        }
    }

    private Instant getExpirationData() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
