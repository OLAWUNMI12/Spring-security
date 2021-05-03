package com.myspring.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/csss/*", "/js/*" ).permitAll()
//                .antMatchers("/home/kick").hasRole("Football")
//                .antMatchers("/home/swing").hasRole("Tennis")
//                .antMatchers("/home/run").hasAuthority(ApplicationUserRoles.TENNIS_RUN)
//                .antMatchers("/home/throw").hasAuthority(ApplicationUserRoles.FOOTBALL_THROW)
//                .antMatchers("/home/kick").hasAuthority(ApplicationUserRoles.FOOTBALL_KICK)
//                .antMatchers("/home/swing").hasAuthority(ApplicationUserRoles.TENNIS_SWING)
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic()
                .formLogin();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails football = User.builder()
                                    .username("Mason")
                                    .password(passwordEncoder.encode("Mason"))
                    //               .roles("Football")
                                    .authorities(ApplicationUserRoles.getFootballRoles())
                                    .build();

        UserDetails tennis = User.builder()
                                    .username("Jab")
                                    .password(passwordEncoder.encode("Jab"))
                    //                .roles("Tennis")
                                    .authorities(ApplicationUserRoles.getTennisRoles())
                                    .build();

        UserDetails mainCoach = User.builder()
                                    .username("mainCoach")
                                    .password(passwordEncoder.encode("mainCoach"))
                    //                .roles("MainCoach")
                                    .authorities(ApplicationUserRoles.getMainCoachRoles())
                                    .build();

        UserDetails assistantCoach = User.builder()
                                    .username("ACoach")
                                    .password(passwordEncoder.encode("ACoach"))
                    //                .roles("AssistantCoach")
                                    .authorities(ApplicationUserRoles.getAssistantCoachRoles())
                                    .build();
        return new InMemoryUserDetailsManager(football, tennis, mainCoach, assistantCoach);

    }
}
