package Model;

import java.util.UUID;
import java.time.LocalDateTime;

public class Player implements ShowDetail {
    private int highscore, totalCoins, totalDistance;
    private String username;
    private UUID playerID;
    private LocalDateTime createdAt;

    public Player (String username){
        this.username = username;
        this.playerID = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.highscore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
    }
    public UUID getPlayerID() {
        return playerID;
    }

    public void updatehighscore(int newscore){
        this.highscore = newscore;
    }

    public void getCoins(int coins){
        this.totalCoins += coins;
    }

    public void addDistance (int newdistance){
        this.totalDistance += newdistance;
    }

    @Override
    public void showDetails(){
        System.out.println("Username: " + username);
        System.out.println("Highscore: " + highscore);
        System.out.println("Total Coins: " + totalCoins);
        System.out.println("Total Distance: " + totalDistance);
        System.out.println("Created At: " + createdAt);

        System.out.println("--------------------------------------------------");
    }
}
