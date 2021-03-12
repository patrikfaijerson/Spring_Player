package com.example.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DemoController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(path = "/player")
    List<Player> getAll() {
        List<Player> players = new ArrayList<>();
        for (Player p : playerRepository.findAll()) {
            players.add(p);
        }
        return players;
    }

    
    @GetMapping(path = "/player/{id}")
    Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerRepository.findById(id);
    }

    @PutMapping(path = "/player/{id}", consumes="application/json", produces="application/json")
        Player updatePlayer(@PathVariable Integer id, @RequestBody Player playerToUpdate){
            Player savedPlayer = playerRepository.findById(id).get();
            savedPlayer.setName(playerToUpdate.getName());
            savedPlayer.setAge(playerToUpdate.getAge());
            savedPlayer.setJerseyNumber(playerToUpdate.getJerseyNumber());
            playerRepository.save(savedPlayer);
            return savedPlayer;
    }

    @PostMapping(path = "/player", consumes="application/json", produces="application/json")
        ResponseEntity<Player> createPlayer(@RequestBody Player playerToCreate){
            playerRepository.save(playerToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(playerToCreate.getId())
                .toUri();
            return ResponseEntity.created(location).build();    

    }

    @DeleteMapping(path = "/player/{id}")
    void deletePlayer(@PathVariable Integer id){
        playerRepository.deleteById(id);
}

    
}