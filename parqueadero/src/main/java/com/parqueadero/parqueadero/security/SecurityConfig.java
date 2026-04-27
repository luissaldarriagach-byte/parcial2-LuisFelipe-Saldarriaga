package com.parqueadero.parqueadero.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/vehiculos/entrada").hasRole("ADMIN")
                .requestMatchers("/vehiculos/ubicacion/**").hasRole("ACOMODADOR")
                .requestMatchers("/vehiculos/**").hasAnyRole("ADMIN", "CLIENTE")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/", true)
            );

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMIN")
                .build();

        UserDetails cliente = User.withDefaultPasswordEncoder()
                .username("cliente")
                .password("123")
                .roles("CLIENTE")
                .build();

        UserDetails acomodador = User.withDefaultPasswordEncoder()
                .username("acomodador")
                .password("123")
                .roles("ACOMODADOR")
                .build();

        return new InMemoryUserDetailsManager(admin, cliente, acomodador);
    }
}