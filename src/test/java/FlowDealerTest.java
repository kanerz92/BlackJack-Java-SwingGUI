//import org.junit.jupiter.api.Test;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//public class FlowDealerTest {
//    IHandToScore mockHandToScore = mock(HandToScore.class);
//    iDealer mockDealer = mock(Dealer.class);
//    iFlowDealerHitRules mockFlowDealerHitRules = mock(FlowDealerHitRules.class);
//    iFlowDealer flowDealer = new FlowDealer(mockHandToScore, mockDealer, mockFlowDealerHitRules);
//    iHand mockDealerHand = mock(Hand.class);
//    iDeck mockDeck = mock(Deck.class);
//
//
//    @Test
//    void testWhenDealerIsOver16ThenNoHit() {
//        //Given: I am a user
//        //When: The dealer is over 16
//        given(mockFlowDealerHitRules.dealerHit(mockHandToScore.scoreHand(mockDealerHand.getHand()))).willReturn(false);
//        flowDealer.dealerFlow(mockDealerHand, mockDeck);
//        //Then: They do not hit
//        verify(mockDealer, never()).dealACard(mockDeck.getDeck());
//    }
//
//    @Test
//    void testWhenDealerIsUnder16ThenHit() {
//        //TODO: How do we test this?!
//        //Given: I am a user
//        //When: The dealer is under 16
//        //given(mockFlowDealerHitRules.dealerHit(mockHandToScore.scoreHand(mockDealerHand.getHand()))).willReturn(true);
//        //flowDealer.dealerFlow(mockDealerHand, mockDeck);
//        //Then: They hit
//        //verify(mockDealer, atLeastOnce()).dealACard(mockDeck.getDeck());
//    }
//}
