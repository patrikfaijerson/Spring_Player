package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(path = "/players")
    List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        for (Player p : playerRepository.findAll()) {
            players.add(p);
        }
        return players;
    }

    
    @GetMapping(path = "/players/{id}")
    Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerRepository.findById(id);
    }

    @PutMapping(path = "/players/{id}")
        void updatePlayer(@RequestBody Player playerToUpdate){
            playerRepository.save(playerToUpdate);
    }

    @PostMapping(path = "/players")
        void createPlayer(@RequestBody Player playerToCreate){
            playerRepository.save(playerToCreate);
    }

    @DeleteMapping(path = "/players/{id}")
    void deletePlayer(@PathVariable Integer id){
        playerRepository.deleteById(id);
}

    
}