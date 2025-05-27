package com.dev.spring_security.model;

import com.dev.spring_security.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(of = "idUser")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "users")
@Table(name = "users")
public class UsersModel implements UserDetails {

    public UsersModel(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUser;

    @NotBlank(message = "O campo 'login' não pode ser vazio. Por favor, forneça um valor válido.")
    @Column(name = "login", nullable = false)
    private String login;

    @NotBlank(message = "O campo 'password' não pode ser vazio. Por favor, forneça um valor válido.")
    @Column(name = "password", nullable = false)
    private String password;

//    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
