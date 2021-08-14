public class BettingTracker implements iBettingTracker{

    @Override
    public void trackBet(int bet, Player player) {
        player.setChips(player.getChips() + bet);
    }
}
