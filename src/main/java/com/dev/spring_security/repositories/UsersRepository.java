package com.dev.spring_security.repositories;

import com.dev.spring_security.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, String> {

    UserDetails findByLogin(String login);
}
