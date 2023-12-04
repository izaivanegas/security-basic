package com.example.security.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@Slf4j
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> authorities = new ArrayList<>();


    public UserAccount() {
    }

    public UserAccount(String username, String password, String...authorities) {
        this.username = username;
        this.password = password;

        this.authorities = Arrays.stream(authorities)
                .map(SimpleGrantedAuthority::new)
                .map(GrantedAuthority.class::cast)
                .toList();

    }


    /***
     * Este metodo no hace un desencriptado del password
     * por lo q se pone lo mismo y pasa
     * @return
     */
    public UserDetails asUser() {

        return User.withDefaultPasswordEncoder() //
                .username(getUsername()) //
                .password(getPassword()) //
                .authorities(getAuthorities()) //
                .build();
    }


}
