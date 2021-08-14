import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BlackJackPanel extends JPanel{
    GridBagConstraints gc;
    private JLabel gameTitle;
    private JButton loginButton;
    private JButton hitButton;
    private JButton standButton;
    private JButton betButton;
    private JTextArea gameLogger;
    private JScrollPane gameLoggerScrolPane;
    private JTextArea leaderboardTextArea;
    private JTextField usernameTextField;
    private JTextField betTextField;
    private JLabel playerCardsLabel;
    private JLabel dealerCardsLabel;
    private JLabel playerCards;
    private JLabel dealerCards;
    private ButtonListener buttonListener;

    public BlackJackPanel() {
        setBackground(new Color(61, 61, 61));
        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0.3;
        gc.weighty = 0.3;

//        gc.gridx = 1;
//        gc.gridy = 1;
//        gc.anchor = GridBagConstraints.CENTER;
//        gc.fill = GridBagConstraints.NONE;
//        gameTitle = new JLabel("BlackJack");
//        gameTitle.setFont(new Font("", Font.PLAIN, 24));
//        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
//        add(gameTitle, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        loginButton = new JButton("Login");
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginButton, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        usernameTextField = new JTextField("",20);
        add(usernameTextField, gc);


        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        hitButton = new JButton("Hit");
        add(hitButton, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        standButton = new JButton("Stand");
        add(standButton, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        betButton = new JButton("Bet");
        add(betButton, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        gameLogger = new JTextArea(6, 30);
        gameLoggerScrolPane = new JScrollPane(gameLogger);
        setPreferredSize(new Dimension(100, 100));
        add(gameLoggerScrolPane, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        leaderboardTextArea = new JTextArea();
        leaderboardTextArea.setEditable(false);
        add(leaderboardTextArea, gc);

        gc.gridx = 2;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.HORIZONTAL;
        betTextField = new JTextField(20);
        add(betTextField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        playerCardsLabel = new JLabel("Player Cards");
        playerCardsLabel.setFont(new Font("", Font.PLAIN, 24));
        playerCardsLabel.setForeground(Color.WHITE);
        add(playerCardsLabel, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        dealerCardsLabel = new JLabel("Dealer Cards");
        dealerCardsLabel.setFont(new Font("", Font.PLAIN, 24));
        dealerCardsLabel.setForeground(Color.WHITE);
        add(dealerCardsLabel, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        playerCards = new JLabel("");
        playerCards.setFont(new Font("", Font.PLAIN, 24));
        playerCards.setForeground(Color.WHITE);
        add(playerCards, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        dealerCards = new JLabel("");
        dealerCards.setFont(new Font("", Font.PLAIN, 24));
        dealerCards.setForeground(Color.WHITE);
        add(dealerCards, gc);

        activateLoginButtons();


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "login";

                ButtonEvent ev = new ButtonEvent(this, action);

                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });

        betButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "bet";

                ButtonEvent ev = new ButtonEvent(this, action);

                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });

        hitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "hit";

                ButtonEvent ev = new ButtonEvent(this, action);

                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });

        standButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "stand";

                ButtonEvent ev = new ButtonEvent(this, action);

                if (buttonListener != null) {
                    buttonListener.buttonEventOccurred(ev);
                }
            }
        });


    }

    public void setButtonListener (ButtonListener listener) {
        this.buttonListener = listener;
    }

    public void deactivateAllButtons() {
        loginButton.setEnabled(false);
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        betButton.setEnabled(false);
    }

    public void activateLoginButtons() {
        deactivateAllButtons();
        loginButton.setEnabled(true);
    }

    public void activateBetButtons() {
        deactivateAllButtons();
        betButton.setEnabled(true);
    }

    public void activateInGameButtons() {
        deactivateAllButtons();
        hitButton.setEnabled(true);
        standButton.setEnabled(true);
    }

    public String getUsername() {
        return usernameTextField.getText();
    }

    public String getBet() {
        return betTextField.getText();
    }

    public void logMessage(String message) {
        gameLogger.append(message);
    }

    public void displayPlayerCards(String hand) {
        playerCards.setText(hand);
    }

    public void displayDealerCards(String hand) {
        dealerCards.setText(hand);
    }

    public void displayLeaderBoard (ArrayList<Player> leaderboard) {
        String leaderboardString = "";
        for(int i = 0; i < Math.min(3, leaderboard.size() - 1); i++) {
            leaderboardString += (i + 1) + ": " + leaderboard.get(i).toString() + "\n";
        }
        leaderboardString += leaderboard.get(leaderboard.size() - 1);
        leaderboardTextArea.setText(leaderboardString);
    }
}