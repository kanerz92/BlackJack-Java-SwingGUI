//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
////@ExtendWith(MockitoExtension.class)
//
//
//public class FlowGameTest {
//    iDeck mockDeck = mock(Deck.class);
//    IShuffler mockShuffler = mock(Shuffler.class);
//    iDealer mockDealer = mock(Dealer.class);
//    iHand mockPlayerHand = mock(Hand.class);
//    iHand mockDealerHand = mock(Hand.class);
//    IHandToScore mockHandToScore = mock(HandToScore.class);
//    iFlowPlayer mockFlowPlayer = mock(FlowPlayer.class);
//    iFlowDealer mockFlowDealer = mock(FlowDealer.class);
//    iFlowDealerHitRules mockFlowDealerHitRules = mock(FlowDealerHitRules.class);
//    iHandComparison mockHandComparison = mock(HandComparison.class);
//    IGameResults mockGameResults = mock(GameResults.class);
//    FlowGame flowGame = new FlowGame(mockDeck, mockShuffler, mockDealer, mockPlayerHand, mockDealerHand, mockHandToScore, mockFlowPlayer, mockFlowDealer,
//            mockHandComparison, mockGameResults);
//
//    @Test
//    public void getDeckMethodIsCalled(){
//        //given im playing a game
//        //when I call the flow class method
//        flowGame.flow();
//        //then getDeck is called once
//        verify(mockDeck, atLeastOnce()).getDeck();
//    }
//
//    @Test
//    public void ShuffleMethodIsCalled(){
//        //given im playing a game
//        //when I call the flow class method
//        flowGame.flow();
//        //then shuffle is called once
//        verify(mockShuffler, times(1)).shuffle(anyList());
//    }
//
//    @Test
//    public void dealMethodIsCalled3times(){
//        //given I'm playing a game
//        //when I call the flow class method
//        flowGame.flow();
//        //then deal method is called once
//        verify(mockDealer, times(3)).dealACard(mockDeck.getDeck());
//    }
//
//    @Test
//    public void TwoCardsAreGivenToPlayer(){
//        //given I'm playing a game
//        //when I call the flow class method
//        flowGame.flow();
//        //then 2 cards are given to the player
//        verify(mockPlayerHand, times(2)).addCard(anyInt());
//    }
//
//    @Test
//    public void AtLeast1CardIsGivenToDealer(){
//        //given I'm playing a game
//        //when I call the flow class method
//        flowGame.flow();
//        //then deal method is called once
//        verify(mockDealerHand, atLeastOnce()).addCard(anyInt());
//    }
//
//    @Test
//    public void testPlayerFlowIsCalled(){
//        //given I'm playing a game
//        //when Cards have been dealt
//
//        flowGame.flow();
//        //then the player plays (i.e. FlowPlayer is called)
//        verify(mockFlowPlayer, times(1)).player_flow(mockPlayerHand, mockDeck);
//    }
//
//    @Test
//    public void testIfPlayerBustAfterFlowThenTheyLose(){
//        //given I'm playing a game
//        //when the player is bust
//        given(mockHandToScore.scoreHand(mockPlayerHand.getHand())).willReturn(22);
//        String gameResult = flowGame.flow();
//        //then the player loses
//        assertEquals("Lose", gameResult);
//    }
//
//    @Test
//    public void testIfPlayerNotBustThenDealerPlays(){
//        //given I'm playing a game
//        //when the player is not bust after their go then the dealer plays
//        given(mockHandToScore.scoreHand(mockPlayerHand.getHand())).willReturn(19);
//        flowGame.flow();
//        //then the dealer plays
//        verify(mockFlowDealer, times(1)).dealerFlow(mockDealerHand, mockDeck);
//    }
//
//    @Test
//    public void testPlayerBustThenDealerDoesNotPlay(){
//        //given I'm playing a game
//        //when the player is bust then the dealer does not play
//        given(mockHandToScore.scoreHand(mockPlayerHand.getHand())).willReturn(23);
//        flowGame.flow();
//        //then the dealer does not play
//        verify(mockFlowDealer, never()).dealerFlow(mockDealerHand, mockDeck);
//    }
//
//    @Test
//    public void testWhenTheDealerGoesBustThenPlayerWins(){
//        //given I'm playing a game
//        //when the dealer is bust then player wins
//        given(mockPlayerHand.getHand()).willReturn(new int[] {7,5,7});
//        given(mockHandToScore.scoreHand(mockPlayerHand.getHand())).willReturn(19);
//        given(mockDealerHand.getHand()).willReturn(new int[] {10,4,8});
//        given(mockHandToScore.scoreHand(mockDealerHand.getHand())).willReturn(22);
//        String gameResult = flowGame.flow();
//        System.out.println(gameResult);
//        //then the player wins
//        assertEquals("Win", gameResult);
//    }
//
//    @Test
//    public void testWhenDealerAndPlayerNotBustThenScoresCompared(){
//        //given I'm playing a game
//        //when the dealer and player are not bust
//        given(mockPlayerHand.getHand()).willReturn(new int[] {7,5,7});
//        given(mockHandToScore.scoreHand(mockPlayerHand.getHand())).willReturn(19);
//        given(mockDealerHand.getHand()).willReturn(new int[] {10,2,7});
//        given(mockHandToScore.scoreHand(mockDealerHand.getHand())).willReturn(19);
//        String gameResult = flowGame.flow();
//        int playerScore = mockHandToScore.scoreHand(mockPlayerHand.getHand());
//        int dealerScore = mockHandToScore.scoreHand(mockDealerHand.getHand());
//        //then compareHand is called
//        verify(mockHandComparison, times(1)).compareHand(playerScore, dealerScore);
//    }
//}