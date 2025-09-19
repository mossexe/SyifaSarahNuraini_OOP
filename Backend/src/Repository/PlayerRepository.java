package Repository;
import Model.Player;

import java.util.Map;
import java.util.Optional;
import java.util.stream

import static java.util.Arrays.stream;

public class PlayerRepository <Player, UUID> extends BaseRepository {
    public Optional<Player> findByUsername(String username)
    {
        return [Map variabel].stream().filter(player -> player.getUsername().equals(username)).findFirst();
    }
}
