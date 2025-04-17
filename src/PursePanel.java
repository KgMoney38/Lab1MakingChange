import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel implements PurseObserver {
    private JTextArea display;

    public PursePanel(Purse purse) {
        purse.addObserver(this); // Register this panel as an observer

        display = new JTextArea(10, 40);
        display.setEditable(false);

        setLayout(new BorderLayout());
        add(new JScrollPane(display), BorderLayout.CENTER);

        // Initial state
        update(purse);
    }

    @Override
    public void update(Purse purse) {
        display.setText(purse.toString());
    }
}
