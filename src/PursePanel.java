import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;

public class PursePanel extends JPanel {
    private Purse purse;
    private Map<String, Image> imageCache = new HashMap<>();

    public PursePanel() {
        purse = new Purse();
        //Set layout like in Kotlin FlowLayout works too but GridBag looks better
        this.setPreferredSize(new Dimension(600, 400));
        this.setBackground(Color.BLUE);
    }

    public void updatePurse(Purse newPurse)
    {
        this.purse = newPurse;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (purse == null|| purse.getCash().isEmpty())
        {
             return;
        }

        //Sort function. Had to find this online to get display in order from greatest to least
        List<Map.Entry<Denomination, Integer>> denomsSorted = new ArrayList<>(purse.getCash().entrySet());
        denomsSorted.sort(Comparator.comparingDouble((Map.Entry<Denomination, Integer> e) -> e.getKey().amt()).reversed());

        int x = 20;
        int y = 20;

        for (Map.Entry<Denomination, Integer> entry : denomsSorted)
        {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            String imgPath = "images/" + denomination.img() + ".png";
            Image image = imageCache.computeIfAbsent(imgPath, path ->
                    new ImageIcon(getClass().getClassLoader().getResource(path)).getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));
            for(int i=0; i< count; i++)
            {
                g.drawImage(image, x+ (i*110), y, this);
            }
            g.setColor(Color.WHITE);
            g.drawString(count + " x " + denomination.name(), x, y +70);
            y+=80;
        }
    }
}
