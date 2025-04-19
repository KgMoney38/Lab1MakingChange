import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//Heavily Updated for lab4

//The main panel for the user input, display, and control layout
public class RegisterPanel extends JPanel {
    private Register register;
    private JTextField input;
    private JButton makeChangeButton;
    private PursePanel changePanel;

    //Initializes my register and sets up the layout
    public RegisterPanel() {
        List<Denomination> denominations = DenominationFactory.createAll();
        ChangeStrategy strategy = new GreedyChangeStrategy(denominations);
        register = new Register(strategy);

        setupUI();
    }

    //Sets up the UI layout and the event handling
    private void setupUI() {
        setLayout(new BorderLayout(0, 10));
        setBackground(Color.WHITE);

        //My instruction label
        JLabel instructions = new JLabel("Enter an amount to make change in US Dollars!!!", SwingConstants.CENTER);
        instructions.setFont(new Font("Arial", Font.BOLD, 18));
        instructions.setForeground(new Color(44, 62, 80));
        instructions.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(instructions, BorderLayout.NORTH);

        //The money input field
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        inputPanel.setBackground(new Color(44, 62, 80)); // Deep blue

        JLabel label = new JLabel("Enter Amount: $");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);

        input = new JTextField(10);
        input.setFont(new Font("Arial", Font.PLAIN, 18));
        input.setPreferredSize(new Dimension(140, 40));
        input.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        makeChangeButton = new JButton("$Make Change$");
        makeChangeButton.setFont(new Font("Arial", Font.BOLD, 16));
        makeChangeButton.setPreferredSize(new Dimension(170, 45));
        makeChangeButton.setForeground(Color.WHITE);
        makeChangeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Found this online to force set the background to red for my button
        makeChangeButton.setOpaque(true);
        makeChangeButton.setContentAreaFilled(true);
        makeChangeButton.setBorderPainted(false);
        makeChangeButton.setBackground(Color.RED);

        inputPanel.add(label);
        inputPanel.add(input);
        inputPanel.add(makeChangeButton);

        //Panel showing the output for my change
        changePanel = new PursePanel(new Purse());
        changePanel.setPreferredSize(new Dimension(600, 350));
        changePanel.setBackground(Color.WHITE);
        changePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 210), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        //Basic footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(192, 57, 43));
        footerPanel.setPreferredSize(new Dimension(100, 40));
        JLabel footerLabel = new JLabel("Making Change - Revamped Using Observer Pull & Strategy Design Patterns");
        footerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        //Put the panels in a main center container
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(changePanel, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        //Add listener for my button and the enter key
        makeChangeButton.addActionListener(new ChangeListener());
        input.addActionListener(new ChangeListener());
    }

    //Handles the input and updates the display with new change
    private void processInput() {
        try {
            double amount = Double.parseDouble(input.getText());
            if (amount < 0.004) {
                changePanel.update(new Purse());
            } else {
                Purse purse = register.makeChange(amount);
                changePanel.update(purse);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    //Listens for the button and enter key
    private class ChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            processInput();
        }
    }
}
