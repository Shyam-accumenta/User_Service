package com.accumenta.User_Service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain sf(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(Customizer -> Customizer.disable());
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails user1= User.withDefaultPasswordEncoder()
                .username("uha")
                .password("ammu")
                .roles("user")
                .build();
        UserDetails user2= User.withDefaultPasswordEncoder()
                .username("aha")
                .password("Uha@123")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}

