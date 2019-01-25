package ebmss;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

public class ReadingDifference extends JFrame {

    String snum1, snum2; 
    int num1, num2;
    JTextField text1;
    private JLabel label1;
    private JTextField text2;
    private JLabel label2; 
    private JButton cal; // calculate button 
    private JButton canc; // cancel button 

    public ReadingDifference() {
        super("Consumption Calculator");
        setLayout(new FlowLayout(200, 100, 20));
        TheHandeler handeler = new TheHandeler();

        label1 = new JLabel("Enter pervious reading");
        add(label1);

        text1 = new JTextField(40);
        text1.addActionListener(handeler);
        add(text1);

        label2 = new JLabel("Enter current reading");
        add(label2);

        text2 = new JTextField(40);
        text2.addActionListener(handeler);
        add(text2);

        canc = new JButton("Cancel");
        canc.addActionListener(handeler);
        add(canc);
        
        cal = new JButton("calculate");
        cal.addActionListener(handeler);
        add(cal);
        
    }
 

    private class TheHandeler implements ActionListener {
        
    
        public void actionPerformed(ActionEvent event) {
            snum1 = text1.getText();
            snum2 = text2.getText();

            if (event.getSource() == canc) {

                System.exit(0);
            } else {

                try {
                    num1 = Integer.parseInt(snum1);
                    num2 = Integer.parseInt(snum2);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "you have entered non-integer value", "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                CalculateConsumption calculator = new CalculateConsumption(num1, num2);
               
                calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                calculator.setSize(700, 400); // setting the width and height 
                calculator.setLocationRelativeTo(null); // align the JFrame to the Center of the display
                calculator.setVisible(true); // show the JFrame to be seen  
            }
        }

    }

}
