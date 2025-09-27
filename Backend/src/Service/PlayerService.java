package Service;

import Model.Player;
import java.util.*;
import java.util.stream.Collectors;
import Model.Player;

public class PlayerService {
    private PlayerRepository playerRepository;

    public boolean existsByUsername(String username) {
        return playerRepository.findByUsername(username) !=null;
    }
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player player) {
        if (existsByUsername((player.getUsername())))
            throw new RuntimeException("Player already exists");
    }

    public Player getPlayerById(UUID playerID) {
        return playerRepository.findById(playerID);
    }
    public Player getPlayerByUserame(String username) {
        return playerRepository.findByUsername(Username);
    }
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    public Player updatePlayer(UUID playerID, Player UpdatedPlayer) {
        Player now = playerRepository.findById(playerID);
        if (now == null){
            throw new RuntimeException("Player not found");
        }
    }
    public void deletePlayer(UUID playerID) {
        playerRepository.deleteById(playerID);
    }
    public void deleteByUserame(String username) {
        playerRepository.
    }

    public Player updatePlayerStats(UUID playerId, int scoreValue, int coinsCollected, int
            distanceTravelled){

    }

    public List<Player> getLeaderboardByHighscore(int limit) {

    }

    public List<Player> getLeaderboardByHighScore(int limit){

    }
    public List<Player> getLeaderboardByTotalCoins(){

    }
    public List<Player>  getLeaderboardByTotalDistance(){

    }
}
