public class FlowDealerHitRules implements iFlowDealerHitRules {

    public boolean dealerHit(int dealerScore) {

        if(dealerScore <= 16) {
            return true;
        }
        return false;
    }
}
