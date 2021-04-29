package com.myspring.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/csss/*", "/js/*" ).permitAll()
                .antMatchers("/home/kick").hasRole("Football")
                .antMatchers("/home/swing").hasRole("Tennis")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails football = User.builder()
                                    .username("Mason")
                                    .password(passwordEncoder.encode("Mason"))
                                    .roles("Football")
                                    .build();

        UserDetails tennis = User.builder()
                .username("Jab")
                .password(passwordEncoder.encode("Jab"))
                .roles("Tennis")
                .build();
        return new InMemoryUserDetailsManager(football,tennis);

    }
}
