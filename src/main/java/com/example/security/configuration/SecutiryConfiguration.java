package com.example.security.configuration;

import com.example.security.domain.UserAccount;
import com.example.security.repository.UserManagementRepository;
import com.example.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecutiryConfiguration {


    /**
     * Esto se usa cuando se usa la entrada con la memoria
     *
     * @return
     */
    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetailsManager userDetailsManager =
                new InMemoryUserDetailsManager();
        userDetailsManager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build());
        userDetailsManager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("ADMIN")
                        .build());
        return userDetailsManager;
    }*/
    /*
    @Bean
    CommandLineRunner initUsers( UserManagementRepository repository){
        System.out.println("Se hace cada ves?");
        return args -> {
            repository.save(new UserAccount("izai","vanegas","ROLE_ADMIN"));
            repository.save(new UserAccount("user","password","ROLE_USER"));

        };
    }
    */



    @Bean
    UserDetailsService userDetailsService(UserRepository repo){
        System.out.println("userDetailsService...........");
        return username -> repo.findByUsername(username).asUser();
    }



    /*protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("user")
                .password(passwordEncoder().encode("password")).roles("USER");

    }*/

/*

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/



}
