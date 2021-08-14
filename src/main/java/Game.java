public class Game {
    private iDeck deck;
    private iHand playerHand;
    private iHand dealerHand;
    private Player player;
    private int bet;

    public iDeck getDeck() {
        return deck;
    }

    public void setDeck(iDeck deck) {
        this.deck = deck;
    }

    public iHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(iHand playerHand) {
        this.playerHand = playerHand;
    }

    public iHand getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(iHand dealerHand) {
        this.dealerHand = dealerHand;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}