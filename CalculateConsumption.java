package ebmss;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class CalculateConsumption extends JFrame {

    private JTextField Answer;
    private JLabel labelA;
    private JTextField TBirr;
    private JTextField TLevel;
    private JLabel labelB;
    private JLabel labelC;
    private JLabel labelD;
    private JButton pay;
    private JButton cancel;

    public CalculateConsumption(int red1, int red2) {
        super("Consumtion Report ");

        double result;
        int level = 0;
        result = (red2 - red1) / 720;

        setLayout(new FlowLayout(300, 150, 50));
        labelA = new JLabel("The consumtion is");
        add(labelA);
        Answer = new JTextField(result + "KilloWatt", 10);
        Answer.setEditable(false);
        add(Answer);
        labelD = new JLabel("consumtion level:");
        add(labelD);

        double bir = 0;
        if (result < 50) {
            if (result < 1) {
                bir = 0.2730;
            } else {
                bir = result * 0.2730;
                level = 1;
            }
        } else if (result >= 50 && result < 100) {
            bir = result * 0.7670;
            level = 2;
        } else if (result >= 100 && result < 200) {
            bir = result * 1.6250;
            level = 3;
        } else if (result >= 200 && result < 300) {
            bir = result * 2;
            level = 4;
        } else if (result <= 300 && result < 400) {
            bir = result * 2.2000;
            level = 5;
        } else if (result >= 400 && result < 100) {
            bir = result * 2.4050;
            level = 6;
        } else if (result >= 500) {
            bir = result * 2.4810;
            level = 7;
        } else {
            labelC = new JLabel("Your consumtion in birr is Unknown");
            add(labelC);
        }
        TLevel = new JTextField("Level" + level, 10);
        TLevel.setEditable(false);
        add(TLevel);
        
        labelB = new JLabel("Your consumtion in birr is");
        add(labelB);

        TBirr = new JTextField(bir + "ETB", 10);
        TBirr.setEditable(false); // textfield can not be chaned further
        add(TBirr);
        
        TheHandeler2 handeler2 = new TheHandeler2();
        pay = new JButton("Pay bill");
        pay.addActionListener(handeler2);
        add(pay);
        
        cancel = new JButton("cancel");
        cancel.addActionListener(handeler2);
        add(cancel);

    }

    private class TheHandeler2 implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == cancel) {
                      
                System.exit(0);
            } else {
                
                Report rprt = new Report();
                 setVisible(false);
                new Report().setVisible(true);
               
                rprt.setVisible(true); // show the JFrame to be seen
               
                if (event.getSource() == cancel) {

                System.exit(0);
            } else {

                
                    
                
              
                

                Payments calculator = new Payments();
               
                calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                calculator.setSize(700, 400); // setting the width and height 
                calculator.setLocationRelativeTo(null); // align the JFrame to the Center of the display
                calculator.setVisible(true); // show the JFrame to be seen  
            }
               
            }

        }

    }

}
