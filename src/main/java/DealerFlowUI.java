public class DealerFlowUI implements IDealerFlowUI{

    iFlowDealerHitRules flowDealerHitRules;
    IHandToScore handToScore;
    iDealer dealer;

    public DealerFlowUI(iFlowDealerHitRules flowDealerHitRules, IHandToScore handToScore, iDealer dealer) {
        this.flowDealerHitRules = flowDealerHitRules;
        this.handToScore = handToScore;
        this.dealer = dealer;
    }

    public void flow(Game game) {
                while (flowDealerHitRules.dealerHit(handToScore.scoreHand(game.getDealerHand().getHand()))){
            int card = dealer.dealACard(game.getDeck().getDeck());
            game.getDealerHand().addCard(card);
        }
    }
}
