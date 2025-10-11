package com.syifa.backend.controller;

import com.syifa.backend.Model.Score;
import com.syifa.backend.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        try {
            Score createdScore = scoreService.createScore(score);
            return new ResponseEntity<>(createdScore, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Score>> getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return new ResponseEntity<>(scores, HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Score>> getScoresByPlayerId(@PathVariable UUID playerId) {
        List<Score> scores = scoreService.getScoresByPlayerId(playerId);
        if (scores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scores, HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}/sorted")
    public ResponseEntity<List<Score>> getScoresByPlayerIdOrderByValue(@PathVariable UUID playerId) {
        List<Score> scores = scoreService.getScoresByPlayerIdOrderByValue(playerId);
        if (scores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scores, HttpStatus.OK);
    }

    @GetMapping("/leaderboard/{limit}")
    public ResponseEntity<List<Score>> getLeaderboard(@PathVariable int limit) {
        List<Score> leaderboard = scoreService.getLeaderboard(limit);
        return new ResponseEntity<>(leaderboard, HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}/highest")
    public ResponseEntity<Optional<Score>> getHighestScoreByPlayerId(@PathVariable UUID playerId) {
        Optional<Score> highestScore = scoreService.getHighestScoreByPlayerId(playerId);
        if (highestScore.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(highestScore, HttpStatus.OK);
    }

    @PutMapping("/{scoreId}")
    public ResponseEntity<Score> updateScore(@PathVariable UUID scoreId, @RequestBody Score updatedScore) {
        try {
            Score updated = scoreService.updateScore(scoreId, updatedScore);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{scoreId}")
    public ResponseEntity<HttpStatus> deleteScore(@PathVariable UUID scoreId) {
        try {
            scoreService.deleteScore(scoreId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
