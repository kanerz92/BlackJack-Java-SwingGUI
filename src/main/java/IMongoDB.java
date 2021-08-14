import java.util.List;

public interface IMongoDB {

    void create(Player player);
    List<Player> retrieveAllPlayers();
    Player retrievePlayer(String player);
    void updatePlayerChips(Player player);
}
