import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;


public class UserInterface {
    
    public static void main(String args[]) throws FileNotFoundException {
        Unscrambler unscrambler = new Unscrambler();
        unscrambler.setUp();
        JFrame frame = new JFrame("Word Unscrambler");
        JButton button1 = new JButton("Enter");

        

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text:");
        JTextField textField = new JTextField(10);
        JLabel returnLabel = new JLabel();
        
        returnLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        returnLabel.setAlignmentY(JLabel.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(textField);
        panel.add(button1);
        
        frame.add(panel);
        panel.setBackground(Color.CYAN);
        
        frame.add(BorderLayout.SOUTH, panel);
        frame.add(BorderLayout.CENTER, returnLabel);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        frame.setVisible(true);
        

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                String possibleWords = unscrambler.unscramble(userInput);
                returnLabel.setText(possibleWords);
                textField.setText(null);
            }
        });
    }

}
