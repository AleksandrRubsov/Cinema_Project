package ru.ruba.Cinema_Project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/cinema-halls", "/movies",
                                "/movie-sessions/available").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/users/by-email").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cinema-halls", "/movies",
                                "/movie-sessions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/movie-sessions/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/movie-sessions/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/orders", "/shopping-carts/by-user").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/orders/complete").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/shopping-carts/movie-sessions").hasRole("USER")
                        .anyRequest().authenticated()

                )
                .formLogin(form -> form
                        .loginPage("/register"))
                .userDetailsService(userDetailsService)
                .passwordManagement(httpSecurityPasswordManagementConfigurer -> passwordEncoder());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
