package com.syifa.backend.Service;

import com.syifa.backend.Model.Score;
import com.syifa.backend.Repository.ScoreRepository;
import com.syifa.backend.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    // 1. Create a New Score
    @Transactional
    public Score createScore(Score score) {
        // Validate that the player exists
        if (!playerRepository.existsById(score.getPlayerId())) {
            throw new RuntimeException("Player with id " + score.getPlayerId() + " does not exist");
        }

        // Save score
        Score savedScore = scoreRepository.save(score);

        // Update player statistics after saving score
        playerService.updatePlayerStats(
                score.getPlayerId(),
                score.getValue(),
                score.getCoinsCollected(),
                score.getDistanceTravelled()
        );

        return savedScore;
    }

    // 2. Get all scores
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    // 3. Get scores by Player ID
    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    // 4. Get sorted scores by Player ID (descending)
    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    // 5. Get leaderboard (top N scores)
    public List<Score> getLeaderboard(int limit) {
        List<Score> allScores = scoreRepository.findTopScores(); // fetch all sorted descending
        if (limit > allScores.size()) {
            limit = allScores.size();
        }
        return allScores.subList(0, limit);
    }

    // 6. Get player's highest score
    public Optional<Score> getHighestScoreByPlayerId(UUID playerId) {
        List<Score> scores = scoreRepository.findTopScoresByPlayerId(playerId);
        if (scores.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(scores.get(0));
        }
    }

    // 7. Update score
    @Transactional
    public Score updateScore(UUID scoreId, Score updatedScore) {
        Optional<Score> existing = scoreRepository.findById(scoreId);
        if (existing.isEmpty()) {
            throw new RuntimeException("Score with ID " + scoreId + " not found");
        }

        Score score = existing.get();
        score.setValue(updatedScore.getValue());
        score.setCoinsCollected(updatedScore.getCoinsCollected());
        score.setDistanceTravelled(updatedScore.getDistanceTravelled());

        return scoreRepository.save(score);
    }

    // 8. Delete score
    @Transactional
    public void deleteScore(UUID scoreId) {
        if (!scoreRepository.existsById(scoreId)) {
            throw new RuntimeException("Score with ID " + scoreId + " not found");
        }
        scoreRepository.deleteById(scoreId);
    }
}
