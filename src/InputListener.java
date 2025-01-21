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

    //A listener for changes to the input
    public InputListener(Register register, PursePanel pursePanel, JTextField input)
    {
        this.register = register;
        this.pursePanel = pursePanel;
        this.input = input;
    }

    //What happens when input changes
    @Override
    public void actionPerformed(ActionEvent e)
    {
        double amount = Double.parseDouble(input.getText());
        if(amount<0.01)
        {
            pursePanel.updatePurse(new Purse());
        }
        else
        {
            Purse purse = register.makeChange(amount);
            pursePanel.updatePurse(purse);
        }
    }
}
