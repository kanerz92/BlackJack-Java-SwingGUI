//import org.junit.jupiter.api.Test;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//public class MultipleGameFlowTest {
//    @Test
//    public void InputUserNameIsCalledOnce() {
//        // given a game is started
//        iBettingFlow bettingFlow = mock(BettingFlow.class);
//        iBettingValidator bettingValidator =mock(BettingValidator.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//        iInputUserName iInputUserName = mock(InputUserName.class);
//
//        given(iInputUserName.inputUserName()).willReturn("test");
//        given(mongoDB.retrievePlayer(anyString())).willReturn(new Player("test",100));
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(false);
//        // when multiple flow game is called
//        MultipleGameFlow multipleGameFlow = new MultipleGameFlow(bettingFlow,bettingValidator,mongoDB, iInputUserName);
//        multipleGameFlow.multipleGamePlayer();
//
//
//        // then inputUserName is called once
//        verify(iInputUserName,times(1)).inputUserName();
//    }
//
//    @Test
//    public void MongoDbIsCalledOnce() {
//        // given a game is started
//        iBettingFlow bettingFlow = mock(BettingFlow.class);
//        iBettingValidator bettingValidator =mock(BettingValidator.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//        iInputUserName iInputUserName = mock(InputUserName.class);
//
//        given(iInputUserName.inputUserName()).willReturn("test");
//        given(mongoDB.retrievePlayer(anyString())).willReturn(new Player("test",100));
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(false);
//        // when multiple flow game is called
//        MultipleGameFlow multipleGameFlow = new MultipleGameFlow(bettingFlow,bettingValidator,mongoDB, iInputUserName);
//        multipleGameFlow.multipleGamePlayer();
//
//
//        // then retrieve player is called once
//        verify(mongoDB,times(1)).retrievePlayer(anyString());
//    }
//
//    @Test
//    public void BettingValidatorIsCalledOnce() {
//        // given a game is started
//        iBettingFlow bettingFlow = mock(BettingFlow.class);
//        iBettingValidator bettingValidator =mock(BettingValidator.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//        iInputUserName iInputUserName = mock(InputUserName.class);
//
//        given(iInputUserName.inputUserName()).willReturn("test");
//        given(mongoDB.retrievePlayer(anyString())).willReturn(new Player("test",100));
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(false);
//        // when multiple flow game is called
//        MultipleGameFlow multipleGameFlow = new MultipleGameFlow(bettingFlow,bettingValidator,mongoDB, iInputUserName);
//        multipleGameFlow.multipleGamePlayer();
//
//
//        // then betting validator is called once
//        verify(bettingValidator,times(1)).checkFunds(any(),anyInt());
//    }
//
//    @Test
//    public void BettingFlowIsNeverCalled() {
//        // given a game is started
//        iBettingFlow bettingFlow = mock(BettingFlow.class);
//        iBettingValidator bettingValidator =mock(BettingValidator.class);
//        MongoDB mongoDB = mock(MongoDB.class);
//        iInputUserName iInputUserName = mock(InputUserName.class);
//
//        given(iInputUserName.inputUserName()).willReturn("test");
//        given(mongoDB.retrievePlayer(anyString())).willReturn(new Player("test",100));
//
//        // when betting validator returns false
//        given(bettingValidator.checkFunds(any(),anyInt())).willReturn(false);
//
//        MultipleGameFlow multipleGameFlow = new MultipleGameFlow(bettingFlow,bettingValidator,mongoDB, iInputUserName);
//        multipleGameFlow.multipleGamePlayer();
//
//
//        // then betting flow is called never
//        verify(bettingFlow,never()).game(any());
//    }
//}
