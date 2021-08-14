import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel{
    private JTextField loginText;
    private JButton login;
    private ButtonListener buttonListener;

    public LoginPanel() {
        setBackground(new Color(0, 80, 0));

        login = new JButton("Login");
        loginText = new JTextField("Enter Name");

        activateInGameButtons();

        add(login);
        add(loginText);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String action = "login";

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

    public void activateInGameButtons() {
        login.setEnabled(true);
    }

    public void deactivateInGameButtons() {
        login.setEnabled(false);
    }

    public String getLoginName () {
        return loginText.getText();
    }
}
