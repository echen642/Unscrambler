import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.reflect.GenericDeclaration;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;


public class UserInterface {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Word Unscrambler");
        JButton button1 = new JButton("Enter");

        // JMenuBar menuBar = new JMenuBar();
        // JMenu fileButton = new JMenu("FILE");
        // JMenu helpButton = new JMenu("HELP");

        // menuBar.add(fileButton);
        // menuBar.add(helpButton);

        // GridBagLayout grid = new GridBagLayout();
        // GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text:");
        JTextField textField = new JTextField(10);
        JLabel returnLabel = new JLabel();
        
        panel.add(label);
        panel.add(textField);
        panel.add(button1);
        
        frame.add(panel);
        panel.setBackground(Color.CYAN);
        


        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.anchor = GridBagConstraints.PAGE_START;
        frame.add(BorderLayout.SOUTH, panel);
        frame.add(BorderLayout.CENTER, returnLabel);
        // gbc.anchor = GridBagConstraints.CENTER;
        // gbc.gridx = 0;
        // gbc.gridy = 0;    
        // frame.add(button1, gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // frame.add(button2, gbc);

        // // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.ipady = 20;
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // frame.add(button3, gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 1;
        // frame.add(button4, gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // gbc.gridwidth = 2;
        // frame.add(button5, gbc);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        frame.setVisible(true);
    }

}
