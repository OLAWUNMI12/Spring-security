package com.myspring.demo.Controller;

import com.myspring.demo.Model.Person;
import com.myspring.demo.Services.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("home")
 class BasicController {
    List<Person> people = new ArrayList<>();

    @Autowired
    @Qualifier("basicService")
    BasicService basicService;

    @GetMapping(path = "ball")
    public List<Person> come(){
        people.add(new Person("Mathew", "Jack"));
        people.add(new Person("samuel", "Leke"));
        people.add(new Person("john", "snow"));
        return people;
    }

    @PostMapping(path = "{id}")
    public Person getPerson(@PathVariable("id") int id){
        people.add(new Person("Mathew", "Jack"));
        people.add(new Person("samuel", "Leke"));
        people.add(new Person("john", "snow"));
        return people.get(id);
    }

    @GetMapping(path = "/kick")
    @PreAuthorize("hasAuthority('football_kick')")
    public String kick(){
        return "Kicking";
    }

    @GetMapping(path = "/swing")
    @PreAuthorize("hasAuthority('tennis_swing')")
    public String swing(){
        return "Swinging";
    }

    @GetMapping(path = "/run")
    @PreAuthorize("hasAuthority('tennis_run')")
    public String run(){
        return "Running";
    }

    @GetMapping(path = "/throw")
    @PreAuthorize("hasAuthority('football_throw')")
    public String tennisThrow(){
        return "Throwing";
    }
}
