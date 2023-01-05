import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.BorderLayout;


public class UserInterface {
    private Unscrambler unscrambler;
    private JFrame frame;
    private JButton button1;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JLabel returnLabel;

    public UserInterface() throws FileNotFoundException {
        unscrambler = new Unscrambler();
        unscrambler.setUp();
        frame = new JFrame("Word Unscrambler");
        button1 = new JButton("Enter");

        panel = new JPanel();
        label = new JLabel("Enter Text:");
        textField = new JTextField(31);     // Longest word in reference file is 31 letters
        returnLabel = new JLabel();

        returnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        returnLabel.setVerticalAlignment(SwingConstants.CENTER);



        panel.add(label);
        panel.add(textField);
        panel.add(button1);
        
        frame.add(panel);
        panel.setBackground(Color.CYAN);
        
        frame.add(BorderLayout.SOUTH, panel);
        frame.add(BorderLayout.CENTER, returnLabel);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        frame.setVisible(true);

        ActionListener processText = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processText();
            }
        };

        button1.addActionListener(processText);     // JButton generates an ActionEvent when the button is pressed
        textField.addActionListener(processText);   // JTextField generates an ActionEvent when the "Enter" key is pressed
    }

    private void processText() {
        String userInput = textField.getText();
        String possibleWords = unscrambler.unscramble(userInput);
        returnLabel.setText(possibleWords);
        textField.setText(null);
    }

    public static void main(String args[]) throws FileNotFoundException {
        new UserInterface();
    }

}
