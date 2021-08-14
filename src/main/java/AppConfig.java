import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {



    @Bean(name="deck")
    public Deck createDeck(){
    return new Deck();
    }
    @Bean(name="shuffler")
    public Shuffler createShuffler(){
        return new Shuffler();
    }
    @Bean(name="dealer")
    public Dealer createDealer(){
        return new Dealer();
    }
    @Bean(name="playerHand")
    public Hand playerHand(){
        return new Hand();
    }
    @Bean(name="dealerHand")
    public Hand dealerHand(){
        return new Hand();
    }
    @Bean(name="handToScore")
    public HandToScore createHandToScore(){
        return new HandToScore();
    }

    @Bean(name="flowDealerHitRules")
    public FlowDealerHitRules createFlowDealerHitRules(){
        return new FlowDealerHitRules();
    }

    @Bean(name="handComparison")
    public HandComparison createHandComparison(){
        return new HandComparison();
    }

    @Bean(name="bettingValidator")
    public BettingValidator createBettingValidator(){
        return new BettingValidator();
    }

    @Bean(name="bettingTracker")
    public BettingTracker createBettingTracker(){
        return new BettingTracker();
    }

    @Bean(name="mongoDb")
    public MongoDB createMongoDb(){
        return new MongoDB();
    }
    @Bean(name="game")
    public Game createGame(){
        return new Game();
    }

    @Bean(name="loginFlowUI")
    public LoginFlowUI createLoginFlowUI(){
        return new LoginFlowUI(createMongoDb(),createGame());
    }
    @Bean(name="newGameFlowUI")
    public NewGameFlowUI createNewGameFlowUI(){
        return new NewGameFlowUI(createShuffler(),createDealer());
    }
    @Bean(name="hitFlowUI")
    public HitFlowUI createHitFlowUI(){
        return new HitFlowUI(createHandToScore(), createDealer());
    }
    @Bean(name="dealerFlowUI")
    public DealerFlowUI createDealerFlowUI(){
        return new DealerFlowUI(createFlowDealerHitRules(),createHandToScore(),createDealer());
    }
    @Bean(name="betFlowUI")
    public BetFlowUI createBetFlowUI(){
        return new BetFlowUI(createBettingValidator());
    }
    @Bean(name="endOfGameFlow")
    public EndOfGameFlowUI createEndOfGameFlowUI(){
        return new EndOfGameFlowUI(createLeaderboard(),createMongoDb(),createHandComparison(),createHandToScore());
    }
    @Bean(name="leaderboard")
    public Leaderboard createLeaderboard(){
        return new Leaderboard(createMongoDb());
    }
    @Bean(name="gameInterface")
    public GameInterface createGameInterface(){
        return new GameInterface(createLoginFlowUI(),createBetFlowUI(),createDealerFlowUI(),createNewGameFlowUI(),createEndOfGameFlowUI(),createHitFlowUI());
    }
}


