import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HandsPanel extends JPanel{
    private JTextArea playerHands;
    private JTextArea dealerHands;

    public HandsPanel() {
        playerHands = new JTextArea("Player cards go Here");
        dealerHands = new JTextArea("Dealer cards go here");
        add(playerHands);
        add(dealerHands);
    }

    public void addPlayerHand (String handValue) {
        playerHands.append(handValue);
    }

    public void addDealerHand (String handValue) {
        dealerHands.append(handValue);
    }

    public void clearHands() {
        playerHands.setText("");
        dealerHands.setText("");
    }
}
