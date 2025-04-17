import javax.swing.*;
import java.awt.*;
import java.util.Map;

//Displays the contents of the purse using my images
public class PursePanel extends JPanel implements PurseObserver {
    private JPanel coinDisplay;

    //Set up my display panel and registers as an observer
    public PursePanel(Purse purse) {
        purse.addObserver(this);
        setLayout(new BorderLayout());

        coinDisplay = new JPanel();
        coinDisplay.setLayout(new GridLayout(0, 2, 10, 10)); // two columns

        add(new JScrollPane(coinDisplay), BorderLayout.CENTER);
        update(purse); // first draw
    }

    //Only called when the purse updates it updates the coin display
    @Override
    public void update(Purse purse) {
        coinDisplay.removeAll();

        Map<Denomination, Integer> contents = purse.getCash();

        contents.entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getKey().amt(), a.getKey().amt())) // descending
                .forEach(entry -> {
                    Denomination d = entry.getKey();
                    int count = entry.getValue();

                    String iconPath = "/images/" + d.iconName() + ".png";
                    ImageIcon originalIcon = new ImageIcon(getClass().getResource(iconPath));
                    Image scaledImage = originalIcon.getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(scaledImage);

                    JLabel label = new JLabel(count + " x " + d.name(), resizedIcon, JLabel.LEFT);
                    label.setHorizontalTextPosition(JLabel.RIGHT);
                    label.setIconTextGap(10);

                    coinDisplay.add(label);
                });

        revalidate();
        repaint();
    }
}
