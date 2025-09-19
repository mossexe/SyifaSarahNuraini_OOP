package Repository;
import Model.Score;

public class ScoreRepository extends BaseRepository {
    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        return [Map variabel].stream().filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

}
