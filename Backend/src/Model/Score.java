package Model;

import java.util.UUID;
import java.time.LocalDateTime;

public class Score implements ShowDetail{
    private UUID playerID;
    private int value, coinsCollected, distance;
    private LocalDateTime createdAt;
    private UUID ScoreID;

    public Score(UUID playerID, int value, int coinsCollected, int distance) {
        this.playerID = playerID;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distance = distance;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getScoreID() {
        return ScoreID;
    }

    public int getValue(){
            return value;
        }

        public int getCoinsCollected(){
            return coinsCollected;
        }

        public int getDistance(){
            return distance;
        }

        public int getPlayerID(){
            return playerID;
        }

    @Override
    public void showDetail(){
        System.out.println("ScoreID: " + ScoreID);
        System.out.println("PlayerID: " + playerID);
        System.out.println("Value: " + value);
        System.out.println("CoinsCollected: " + coinsCollected);
        System.out.println("Distance: " + distance);
        System.out.println("CreatedAt: " + createdAt);
    }

}
