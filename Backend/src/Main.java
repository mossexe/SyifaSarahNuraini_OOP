//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Model.Player;
import Model.Score;

import java.util.UUID;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Moss");
        Player player2 = new Player("Kura");

        Score score1 = new Score(player1.getPlayerID(), 1500, 250,5000);
        Score score2 = new Score(player2.getPlayerID(),1800,750,12000);
        Score score3 = new Score(player1.getPlayerID(),1800,300,6000);

        player1.updatehighscore(score1.getValue());
        player1.addDistance(score1.getDistance());
        player1.getCoins(score1.getCoinsCollected());

        player1.updatehighscore(score3.getValue());
        player1.addDistance(score3.getDistance());
        player1.getCoins(score3.getCoinsCollected());

        player2.updatehighscore(score2.getValue());
        player2.addDistance(score2.getDistance());
        player2.getCoins(score2.getCoinsCollected());

        player1.showDetails();
        player2.showDetails();
    }

}