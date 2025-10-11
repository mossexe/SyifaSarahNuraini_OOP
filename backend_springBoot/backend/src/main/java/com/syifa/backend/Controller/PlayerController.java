package com.syifa.backend.Controller;

import com.syifa.backend.Model.Player;
import com.syifa.backend.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/players")  // <--- IMPORTANT
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Create new player (POST)
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player created = playerService.createPlayer(player);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get player by username (GET)
    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<Player>> getPlayerByUsername(@PathVariable String username) {
        Optional<Player> player = playerService.getPlayerByUsername(username);
        if (player.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    // Get all players (optional)
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
