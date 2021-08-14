import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FlowDealerHitRulesTest {

    @Test
    public void dealerHitsOnSixteenOrLess() {
        //given I am a dealer
        FlowDealerHitRules dealerRules = new FlowDealerHitRules();
        //when I have a score of 16 or less
        boolean dealerHit = dealerRules.dealerHit(16);
        //then I hit
        assertTrue(dealerHit);
    }

    @Test
    public void dealerStandsBetween17And21() {
        //given I am a dealer
        FlowDealerHitRules dealerRules = new FlowDealerHitRules();
        //when I have a score between 17 and 21
        boolean dealerHit = dealerRules.dealerHit(17);
        //then I stay
        assertFalse(dealerHit);
    }
}