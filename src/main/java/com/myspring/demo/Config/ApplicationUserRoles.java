package com.myspring.demo.Config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class ApplicationUserRoles {

    //Sport roles
    public static final String FOOTBALL_KICK = "football_kick";
    public static final String FOOTBALL_THROW = "football_throw";
    public static final String TENNIS_SWING = "tennis_swing";
    public static final String TENNIS_RUN = "tennis_run";

    //Coach roles
    public static final String COACH_GET = "coach_get";
    public static final String COACH_ADD = "coach_add";
    public static final String COACH_DELETE = "coach_delete";


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

    public static Set<SimpleGrantedAuthority> getMainCoachRoles(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(COACH_GET));
        authorities.add(new SimpleGrantedAuthority(COACH_ADD));
        authorities.add(new SimpleGrantedAuthority(COACH_DELETE));
        return authorities;
    }

    public static Set<SimpleGrantedAuthority> getAssistantCoachRoles(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(COACH_GET));
        return authorities;
    }
}
