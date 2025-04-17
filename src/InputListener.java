import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

//Done.

public class InputListener implements ActionListener
{
    private Register register;
    private PursePanel pursePanel;
    private JTextField input;

    //Just a listener for changes to input
    public InputListener(Register register, PursePanel pursePanel, JTextField input)
    {
        this.register = register;
        this.pursePanel = pursePanel;
        this.input = input;
    }

   //Called when input field triggers a action event
    @Override
    public void actionPerformed(ActionEvent e) {
        double amount = Double.parseDouble(input.getText());
        Purse purse = null;
        if (amount < 0.01) {
            pursePanel.update(purse);
        } else {
            purse = register.makeChange(amount);
            pursePanel.update(purse);
        }
    }
}
