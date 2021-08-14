

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class HitStand implements ActionListener {

    JLabel myLabel;

    public HitStand() {


        JFrame jFrame = new JFrame("Blackjack Game");


        jFrame.setLayout(new FlowLayout());


        jFrame.setSize(1000, 1000);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JButton hit = new JButton("Hit");
        JButton stand = new JButton("Stand");



        myLabel = new JLabel("Oh boy blackjack");




        hit.addActionListener(this);
        stand.addActionListener(this);




        jFrame.add(hit);
        jFrame.add(stand);
        jFrame.add(myLabel);





        jFrame.setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Our playground

        if (e.getActionCommand().equals("Hit")) {

            myLabel.setText("You pressed hit" );
        }else {
            myLabel.setText("You pressed stand");
        }


    }



    public static void main(String[] args) {
        // Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new HitStand();

            }
        });

    }


}
