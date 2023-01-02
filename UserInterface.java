import javax.swing.*;
import java.awt.GridBagLayout;
import java.lang.reflect.GenericDeclaration;
import java.awt.GridBagConstraints;


public class UserInterface {
    public static void main(String args[]) {
        JFrame frame = new JFrame("I am the title of this box");
        JButton button1 = new JButton("Number 1");
        JButton button2 = new JButton("Number 2");
        JButton button3 = new JButton("Number 3");
        JButton button4 = new JButton("Number 4");
        JButton button5 = new JButton("Number 5");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileButton = new JMenu("FILE");
        JMenu helpButton = new JMenu("HELP");

        menuBar.add(fileButton);
        menuBar.add(helpButton);

        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame.setLayout(grid);
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;

        frame.add(menuBar, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;    
        frame.add(button1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(button2, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(button3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(button4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(button5, gbc);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // // frame.getContentPane().add(button);
        // // frame.getContentPane().add(button1);
        frame.setVisible(true);
    }

}
