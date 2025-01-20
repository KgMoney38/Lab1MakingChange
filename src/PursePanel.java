import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        purse = new Purse();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.setPreferredSize(new Dimension(500, 400));
        this.setBackground(Color.BLUE);
    }

    public void updatePurse(Purse newPurse) {
        this.purse = newPurse;
        this.removeAll();

        for(Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet())
        {
            Denomination denomination = entry.getKey();
            int amount = entry.getValue();

            URL imgURL = getClass().getResource("/images/" + denomination + ".png");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.removeAll(); // Clear previous images

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            // Load the image
            ImageIcon icon = new ImageIcon("src/images/" + denomination.img());

            // Resize the image to fit better
            Image scaledImage = icon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(resizedIcon);
            JLabel textLabel = new JLabel(count + " x " + denomination.name());

            this.add(imageLabel);
            this.add(textLabel);
        }

        revalidate();
        repaint();
    }
}
