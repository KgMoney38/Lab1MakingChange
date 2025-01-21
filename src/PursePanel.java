import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.*;
import java.util.List;

public class PursePanel extends JPanel {
    private Purse purse;
    private Map<String, Image> imageCache = new HashMap<>();

    public PursePanel() {
        purse = new Purse(); //Represents the amount to display—initialize to empty Purse
        //Set layout like in Kotlin FlowLayout works too but GridBag looks better
        this.setPreferredSize(new Dimension(600, 400));
        this.setBackground(Color.DARK_GRAY);
    }

    public void updatePurse(Purse newPurse)
    {
        this.purse = newPurse;
        repaint();
    }

    //Holds the logic for displaying purse contents
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
            double count = entry.getValue();
            //Round the pennies for proper output
            if(denomination.amt()==.01)
            {
                count= Math.ceil(count+.001);
            }

            String imgPath = "images/" + denomination.img() + ".png";
            Image image = imageCache.computeIfAbsent(imgPath, path ->
                    new ImageIcon(getClass().getClassLoader().getResource(path)).getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));

            for(int i=0; i< count; i++)
            {
                g.drawImage(image, x+ (i*110), y, this);
            }
                int numberOf= (int) count;

            g.setColor(Color.WHITE);
            g.drawString(numberOf + " x " + denomination.name(), x, y +70);
            y+=80;
        }
    }
}
