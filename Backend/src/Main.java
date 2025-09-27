import Model.Player;
import Model.Score;
import Repository.PlayerRepository;
import Repository.ScoreRepository;
import Service.PlayerService;
import Service.ScoreService;
public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new
                PlayerRepository();
        ScoreRepository scoreRepository = new ScoreRepository();
        PlayerService playerService = new
                PlayerService(playerRepository);
        ScoreService scoreService = new
                ScoreService(scoreRepository, playerRepository, playerService);
        System.out.println("=== CS 4 ===\n");
        Player player1 = new Player("NanaBanana");
        Player player2 = new Player("Yingko");
        Player player3 = new Player("LegdontWork");
        // TODO: Use playerService to save the three players above

        System.out.println("Players created\n");
        // TODO: Tampilkan semua pemain untuk melihat status awal
        mereka

        // TODO: Create 5 new Score objects with the following
        specifications and save them using scoreService
        // Score 1: For player1, score 1500, coins 50, distance
        3000
        // Score 2: For player1, score 2000, coins 75, distance
        4500
        // Score 3: For player2, score 1800, coins 60, distance
        3500
        // Score 4: For player3, score 1200, coins 40, distance
        2500
        // Score 5: For player3, score 2500, coins 90, distance
        5000
        System.out.println("Scores created!\n");
        System.out.println("Player Score:");
        // TODO: Display details of all players to prove that
        their statistics are updated

        System.out.println("Top 2 players by high score");
        // TODO: Display the leaderboard for the top 2 players
        ranked by high score through the service

        System.out.println("All scores for " +
                player1.getUsername() + ":");
        // TODO: Display all scores belonging to player1 through
        the service

        System.out.println("Top 3 scores overall:");
        // TODO: Display the leaderboard for the top 3 overall
        scores through the service
        System.out.println("earching for player 'NanaBanana':");
        // TODO: Search for a player with username "NanaBanana"
        through the service.
                // If found, display the details. If not, print "Player
                not found!".


        System.out.println("Totals for " + player3.getUsername() +
                ":");
        // TODO: Retrieve and print the total coins and total
        distance belonging to player3 through the service.

                System.out.println("Recent scores (ordered by creation
                        time):");
        // TODO: Retrieve all scores ordered by creation time
        through the service, then display the details of each score.
    }
}
