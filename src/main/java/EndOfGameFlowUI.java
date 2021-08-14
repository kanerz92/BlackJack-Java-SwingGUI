import java.util.ArrayList;

public class EndOfGameFlowUI implements IEndOfGameFlowUI{

    ILeaderboard leaderboard;
    IMongoDB mongoDB;
    iHandComparison handcompare;
    IHandToScore handscore;

    public EndOfGameFlowUI(ILeaderboard leaderboard, IMongoDB mongoDB, iHandComparison handcompare, IHandToScore handscore) {
        this.leaderboard = leaderboard;
        this.mongoDB = mongoDB;
        this.handcompare = handcompare;
        this.handscore = handscore;
    }

    public ArrayList<Player> flow(Game game) {

        int playerscore = handscore.scoreHand(game.getPlayerHand().getHand());
        int dealerscore = handscore.scoreHand(game.getDealerHand().getHand());
        handcompare = new HandComparison();
        String result = handcompare.compareHand(playerscore, dealerscore);

        if (result.equals("Win")) {
            game.getPlayer().setChips(game.getPlayer().getChips() + game.getBet());
            mongoDB.updatePlayerChips(game.getPlayer());
        }
        if (result.equals("Lose")) {
            game.getPlayer().setChips(game.getPlayer().getChips() - game.getBet());
            mongoDB.updatePlayerChips(game.getPlayer());
        }

        leaderboard = new Leaderboard(mongoDB);

        IDisplayLeaderboard displayLeaderboard = new DisplayLeaderboard();
        displayLeaderboard.showLeaderboard(leaderboard.returnLeaderboard(game.getPlayer()));

        return leaderboard.returnLeaderboard(game.getPlayer());
    }
}
