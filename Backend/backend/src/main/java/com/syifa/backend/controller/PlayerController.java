package com.syifa.backend.Controller;

import com.syifa.backend.Model.Player;
import com.syifa.backend.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public getAllPlayers{
        playerService.getAllPlayers()
        return ResponseEntity<List<Player>>;
    }
}
