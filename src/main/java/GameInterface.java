import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameInterface extends JFrame {
    JPanel contentPanel;
    BlackJackPanel blackJackPanel;
    Game game;
    ILoginFlowUI loginflow;
    IBetFlowUI betflow;
    IDealerFlowUI dealerflow;
    INewGameFlowUI newflow;
    IEndOfGameFlowUI endflow;
    IHitFlowUI hitflow;

    public GameInterface(LoginFlowUI loginflow,BetFlowUI betflow,DealerFlowUI dealerflow,NewGameFlowUI newflow, EndOfGameFlowUI endflow,HitFlowUI hitflow) {
        super("BlackJack");
        this.loginflow = loginflow;
        this.betflow = betflow;
        this.dealerflow = dealerflow;
        this.newflow = newflow;
        this.endflow = endflow;
        this.hitflow = hitflow;

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        blackJackPanel = new BlackJackPanel();

        setContentPane(contentPanel);

        contentPanel.add(blackJackPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setVisible(true);

        blackJackPanel.setButtonListener(new ButtonListener() {
            public void buttonEventOccurred(ButtonEvent e) {
                String action = e.getAction();
                if (action.equals("login")) {
                    String username = blackJackPanel.getUsername();
                    game = loginflow.flow(username);
                    if (game.getPlayer() != null) {
                        blackJackPanel.activateBetButtons();
                    }
                }
                else if (action.equals("bet")) {
                    String bet = blackJackPanel.getBet();
                    //Todo: Add validation or handle invalid input nicely
                    boolean isValidBet;
                    try {
                        isValidBet = betflow.flow(Integer.parseInt(bet), game);
                    }
                    catch (Exception ex){
                        return;
                    }
                    if (isValidBet) {
                        System.out.println("Valid Bet");
                        newflow.flow(game);
                        blackJackPanel.displayPlayerCards(game.getPlayerHand().toString());
                        blackJackPanel.displayDealerCards(game.getDealerHand().toString());
                        blackJackPanel.activateInGameButtons();
                    }
                }

                else if (action.equals("hit")) {
                    boolean isBust = hitflow.flow(game);
                    blackJackPanel.displayPlayerCards(game.getPlayerHand().toString());
                    if (isBust) {
                        endflow.flow(game);
                        blackJackPanel.activateBetButtons();
                    }
                }

                else if (action.equals("stand")) {
                    blackJackPanel.logMessage("Player stands");
                    dealerflow.flow(game);
                    blackJackPanel.displayDealerCards(game.getDealerHand().toString());
                    ArrayList<Player> leaderboard = endflow.flow(game);
                    blackJackPanel.displayLeaderBoard(leaderboard);
                    blackJackPanel.activateBetButtons();
               }
            }
        });
    }
}