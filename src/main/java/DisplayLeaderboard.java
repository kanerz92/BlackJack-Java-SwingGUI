import java.util.ArrayList;

public class DisplayLeaderboard implements IDisplayLeaderboard {

    @Override
    public void showLeaderboard(ArrayList<Player> lb) {
        for(Player player: lb) {
            System.out.println(player.getName() + " " + player.getChips());
        }
//        System.out.println("Current logged in user" + " " + lb.indexOf(3));
    }
}