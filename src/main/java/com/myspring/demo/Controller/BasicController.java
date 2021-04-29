package com.myspring.demo.Controller;

import com.myspring.demo.Model.Person;
import com.myspring.demo.Services.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private List<Person> come(){
        people.add(new Person("Mathew", "Jack"));
        people.add(new Person("samuel", "Leke"));
        people.add(new Person("john", "snow"));
        return people;
    }

    @PostMapping(path = "{id}")
    private Person getPerson(@PathVariable("id") int id){
        people.add(new Person("Mathew", "Jack"));
        people.add(new Person("samuel", "Leke"));
        people.add(new Person("john", "snow"));
        return people.get(id);
    }

    @GetMapping(path = "kick")
    private String kick(){
        return "Kicking";
    }

    @GetMapping(path = "swing")
    private String swing(){
        return "Swinging";
    }

    @GetMapping(path = "run")
    private String run(){
        return "Running";
    }

    @GetMapping(path = "throw")
    private String tennisThrow(){
        return "Throwing";
    }
}
