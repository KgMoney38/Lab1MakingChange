import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel
{
    private Register register; //A register object to run the logic
    private JTextField input;
    private JButton makeChangeButton;
    private PursePanel changePanel; //A panel to display the change

    public RegisterPanel()
    {
        register = new Register();

        //Study these layouts, they were just recommended by Intelli J
        this.setLayout(new BorderLayout());

        //Make panel and button
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10)); //A panel to hold the JTextField for the user to enter an amount
        input = new JTextField(10); //A place for the user to enter the amount
        makeChangeButton = new JButton("Make Change");

        inputPanel.add(new JLabel("Enter Amount: "));
        inputPanel.add(input);
        inputPanel.add(makeChangeButton);

        changePanel = new PursePanel();
        changePanel.setPreferredSize(new Dimension(500,500));
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);

        makeChangeButton.addActionListener(new changeListener());
        //For enter input just like in Kotlin
        input.addActionListener(new changeListener());
    }
    private void processInput()
    {
        double amount = Double.parseDouble(input.getText());
        if (amount < 0.01) {
            changePanel.updatePurse(new Purse());
        } else {
            Purse purse = register.makeChange(amount);
            changePanel.updatePurse(purse);
        }
    }
    private class changeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            processInput();
        }
    }
}
