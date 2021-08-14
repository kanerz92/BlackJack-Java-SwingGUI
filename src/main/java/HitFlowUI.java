public class HitFlowUI implements IHitFlowUI{
    IHandToScore handToScore;
    iDealer dealer;

    public HitFlowUI(IHandToScore handToScore, iDealer dealer) {
        this.handToScore = handToScore;
        this.dealer = dealer;
    }

    public boolean flow(Game game) {
        dealer = new Dealer();
        handToScore = new HandToScore();
        int card = dealer.dealACard(game.getDeck().getDeck());
        game.getPlayerHand().addCard(card);
        return handToScore.scoreHand(game.getPlayerHand().getHand()) > 21;
    }
}

