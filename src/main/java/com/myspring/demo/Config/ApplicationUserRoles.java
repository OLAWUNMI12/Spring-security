package com.myspring.demo.Config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class ApplicationUserRoles {

    public static final String FOOTBALL_KICK = "football_kick";
    public static final String FOOTBALL_THROW = "football_throw";
    public static final String TENNIS_SWING = "tennis_swing";
    public static final String TENNIS_RUN = "tennis_run";

    public static Set<SimpleGrantedAuthority> getFootballRoles(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(FOOTBALL_KICK));
        authorities.add(new SimpleGrantedAuthority(FOOTBALL_THROW));
        return authorities;
    }

    public static Set<SimpleGrantedAuthority> getTennisRoles(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(TENNIS_RUN));
        authorities.add(new SimpleGrantedAuthority(TENNIS_SWING));
        return authorities;
    }
}
