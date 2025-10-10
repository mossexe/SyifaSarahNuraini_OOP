package com.syifa.backend.Service;
import com.syifa.backend.Model.Score; // sesuaikan
import com.syifa.backend.Repository.ScoreRepository; //sesuaikan
import com.syifa.backend.Repository.PlayerRepository; //sesuaikan
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

    @Transactional
    public Score CreateScore(Score score){
        if(playerRepository.existsById(score.getPlayerId())){
            throw new RuntimeException("Player with id " + score.getPlayerId() + " already exists");
        }
        Score SaveScore = scoreRepository.save(score);
        playerService.updatePlayerStats(score.getPlayerId(), score.getValue(), score.getCoinsCollected(), score.getDistanceTravelled());
        return SaveScore;
    }
}