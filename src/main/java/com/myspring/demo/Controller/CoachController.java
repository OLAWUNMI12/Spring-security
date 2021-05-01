package com.myspring.demo.Controller;

import com.myspring.demo.Model.Player;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("coach")
public class CoachController {

    List<Player> playersList = new ArrayList<>();

    @GetMapping(path = "/getAllPlayers")
    @PreAuthorize("hasAuthority('coach_get')")
    public List<Player> getAvailablePlayers(){
        playersList.add(new Player("james", 20));
        playersList.add(new Player("Rasheed", 22));
        playersList.add(new Player("Paris", 25));
        return playersList;
    }

    @PostMapping(path = "/addPlayers")
    @PreAuthorize("hasAuthority('coach_add')")
    public Player addPlayer(@RequestBody Player player){
        playersList.add(player);
        return player;
    }

    @DeleteMapping(path = "/deleteplayer/{id}")
    @PreAuthorize("hasAuthority('coach_delete')")
    public Player deletePlayer(@PathVariable Integer id){
        Player player = playersList.get(id);
        playersList.remove(id);
        return player;
    }



}
