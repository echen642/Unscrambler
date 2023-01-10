import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.IOException;



public class UserInterface {
    private Unscrambler unscrambler;
    private JFrame frame;
    private JButton button1;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JLabel returnLabel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem fileExplorerItemAdd;
    private JMenuItem fileExplorerItemSetUp;
    private JMenu setUpMenu;
    private JMenu addMenu;
    private JFileChooser fileChooser;

    public UserInterface() throws FileNotFoundException {
        unscrambler = new Unscrambler();
        unscrambler.setUp();
        build();
    }

    private void build() {
        frame = new JFrame("Word Unscrambler");
        button1 = new JButton("Enter");

        panel = new JPanel();
        label = new JLabel("Enter Text:");
        textField = new JTextField(unscrambler.getMaxLength());     // Longest word in default reference file is 31 letters
        returnLabel = new JLabel();
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        fileExplorerItemAdd = new JMenuItem("Choose File");
        fileExplorerItemSetUp = new JMenuItem("Choose File");
        setUpMenu = new JMenu("Set Up");
        addMenu = new JMenu("Add");
        fileChooser = new JFileChooser();

        // Return Label Settings
        returnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        returnLabel.setVerticalAlignment(SwingConstants.CENTER);


        // Adding JComponents to/adjusting JPanel
        panel.add(label);
        panel.add(textField);
        panel.add(button1);
        panel.setBackground(Color.CYAN);

        // Adding JComponents to JFrame
        frame.add(panel);
        frame.add(BorderLayout.NORTH, menuBar);
        frame.add(BorderLayout.SOUTH, panel);
        frame.add(BorderLayout.CENTER, returnLabel);

        // Setting Up AddItem and SetUpItem
        addMenu.add(fileExplorerItemAdd);
        setUpMenu.add(fileExplorerItemSetUp);

        // Adding MenuItem to Menu
        menu.add(addMenu);
        menu.add(setUpMenu);




        fileExplorerItemAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addReferenceFile();
            }
        });

        fileExplorerItemSetUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUpUnscrambler();
            }
        });

        // Adding Menu to MenuBar
        menuBar.add(menu);
    
        // Adjusting settings of JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setVisible(true);


        // Adding functionality to button and textfield
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

    private void addReferenceFile() {
        if (fileChooser.showOpenDialog(fileExplorerItemAdd) == JFileChooser.APPROVE_OPTION) {
            System.out.println("Your selected file is: " + new File(fileChooser.getSelectedFile().getAbsolutePath()));
            try {
                unscrambler.add(fileChooser.getSelectedFile());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("The user has cancelled the operation.");
        }
    }

    private void setUpUnscrambler() {
        if (fileChooser.showOpenDialog(fileExplorerItemSetUp) == JFileChooser.APPROVE_OPTION) {
            try {
                unscrambler.setUp(new File (fileChooser.getSelectedFile().getAbsolutePath()));                            
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else {
            System.out.println("The user has cancelled the operation.");
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        new UserInterface();
    }

}
