package com.zoho.analytics.ssrfvulnerableapplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/checkDeliveryLocation/**").permitAll()
                .antMatchers("/", "/product/**").permitAll() // Permit access to the home and product pages
                .antMatchers("/isDeliverable").access("hasIpAddress('localhost')") // Allow access 
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN') or hasIpAddress('localhost')") // Allow access to admin page for users with admin role or from localhost
                .anyRequest().authenticated() // Require authentication for other URLs
                .and()
                .formLogin(); // Enable form-based authentication
    }
}