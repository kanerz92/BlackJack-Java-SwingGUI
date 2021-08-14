import java.util.ArrayList;

public class Leaderboard implements ILeaderboard{
    IMongoDB mongodb;

    public Leaderboard(IMongoDB mongodb){
        this.mongodb = mongodb;
    }

     @Override
    public ArrayList<Player> returnLeaderboard(Player player) {
         ArrayList<Player> allPlayers = (ArrayList<Player>) mongodb.retrieveAllPlayers();
         allPlayers.sort((playerA, playerB) -> playerB.getChips() - playerA.getChips());
         ArrayList<Player> leaderboard = new ArrayList<Player>();
         for (int i = 0; i < Math.min(3, allPlayers.size()); i++){
             leaderboard.add(allPlayers.get(i));
         }
         leaderboard.add(player);
         return leaderboard;
    }
}
