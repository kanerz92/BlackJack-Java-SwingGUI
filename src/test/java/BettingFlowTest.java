//import org.junit.jupiter.api.Test;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//public class BettingFlowTest {
//    @Test
//    public void bettingInputIsCalled() {
//
//        /// given we start a game
//        iBettingInput bettingInput = mock(BettingInput.class);
//        IFlowGame flowGame = mock(FlowGame.class);
//        iBettingValidator bettingValidator = mock(BettingValidator.class);
//        iBettingTracker bettingTracker = mock(BettingTracker.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//
//
//        given(bettingInput.grabBet()).willReturn("50");
//        given(flowGame.flow()).willReturn("win");
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(true);
//
//        // when betting flow game is called
//        BettingFlow bettingFlow = new BettingFlow(bettingInput,flowGame,bettingValidator,bettingTracker,mongoDB);
//        Player player = new Player("test",100);
//
//        bettingFlow.game(player);
//
//        // then grab bet is called once
//        verify(bettingInput,times(1)).grabBet();
//    }
//
//    @Test
//    public void FlowGameIsCalled() {
//
//        /// given we start a game
//        iBettingInput bettingInput = mock(BettingInput.class);
//        IFlowGame flowGame = mock(FlowGame.class);
//        iBettingValidator bettingValidator = mock(BettingValidator.class);
//        iBettingTracker bettingTracker = mock(BettingTracker.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//
//
//        given(bettingInput.grabBet()).willReturn("50");
//        given(flowGame.flow()).willReturn("win");
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(true);
//
//        // when betting flow game is called
//        BettingFlow bettingFlow = new BettingFlow(bettingInput,flowGame,bettingValidator,bettingTracker,mongoDB);
//        Player player = new Player("test",100);
//
//        bettingFlow.game(player);
//
//        // then flow game is called once
//        verify(flowGame,times(1)).flow();
//    }
//    @Test
//    public void bettingValidatorIsCalled() {
//
//        /// given we start a game
//        iBettingInput bettingInput = mock(BettingInput.class);
//        IFlowGame flowGame = mock(FlowGame.class);
//        iBettingValidator bettingValidator = mock(BettingValidator.class);
//        iBettingTracker bettingTracker = mock(BettingTracker.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//
//
//        given(bettingInput.grabBet()).willReturn("50");
//        given(flowGame.flow()).willReturn("Win");
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(true);
//
//        // when betting flow game is called
//        BettingFlow bettingFlow = new BettingFlow(bettingInput,flowGame,bettingValidator,bettingTracker,mongoDB);
//        Player player = new Player("test",100);
//
//        bettingFlow.game(player);
//
//        // then betting validator is called once
//        verify(bettingValidator,times(1)).checkFunds(any(),anyInt());
//    }
//    @Test
//    public void bettingTrackerIsCalledOnceWhenWin() {
//
//        /// given we start a game
//        iBettingInput bettingInput = mock(BettingInput.class);
//        IFlowGame flowGame = mock(FlowGame.class);
//        iBettingValidator bettingValidator = mock(BettingValidator.class);
//        iBettingTracker bettingTracker = mock(BettingTracker.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//
//
//        given(bettingInput.grabBet()).willReturn("50");
//        given(flowGame.flow()).willReturn("Win");
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(true);
//
//        // when betting flow game is called with flow game returning Win
//        BettingFlow bettingFlow = new BettingFlow(bettingInput,flowGame,bettingValidator,bettingTracker,mongoDB);
//        Player player = new Player("test",100);
//
//        bettingFlow.game(player);
//
//        // then betting tracker is called once
//        verify(bettingTracker,times(1)).trackBet(anyInt(),any());
//    }
//    @Test
//    public void bettingTrackerIsCalledWhenLose() {
//
//        /// given we start a game
//        iBettingInput bettingInput = mock(BettingInput.class);
//        IFlowGame flowGame = mock(FlowGame.class);
//        iBettingValidator bettingValidator = mock(BettingValidator.class);
//        iBettingTracker bettingTracker = mock(BettingTracker.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//
//
//        given(bettingInput.grabBet()).willReturn("50");
//        given(flowGame.flow()).willReturn("Lose");
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(true);
//
//        // when betting flow game is called
//        BettingFlow bettingFlow = new BettingFlow(bettingInput,flowGame,bettingValidator,bettingTracker,mongoDB);
//        Player player = new Player("test",100);
//
//        bettingFlow.game(player);
//
//        // then betting tracker is called once
//        verify(bettingTracker,times(1)).trackBet(anyInt(),any());
//    }
//    @Test
//    public void bettingTrackerIsNevelCalled() {
//
//        /// given we start a game
//        iBettingInput bettingInput = mock(BettingInput.class);
//        IFlowGame flowGame = mock(FlowGame.class);
//        iBettingValidator bettingValidator = mock(BettingValidator.class);
//        iBettingTracker bettingTracker = mock(BettingTracker.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//
//
//        given(bettingInput.grabBet()).willReturn("50");
//        given(flowGame.flow()).willReturn("Draw");
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(true);
//
//        // when flow game returns draw
//        BettingFlow bettingFlow = new BettingFlow(bettingInput,flowGame,bettingValidator,bettingTracker,mongoDB);
//        Player player = new Player("test",100);
//
//        bettingFlow.game(player);
//
//        // then betting tracker in never called
//        verify(bettingTracker,never()).trackBet(anyInt(),any());
//    }
//
//}
