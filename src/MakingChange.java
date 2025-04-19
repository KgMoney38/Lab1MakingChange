import javax.swing.*;
//Slightly updated

//Class that launches my app
public class MakingChange {
    public static void main(String[] args) {

        //Just sets my GUI components to the native system style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Could not set Look and Feel");
        }

        //Open my app window
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("$$$Making Change$$$");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 800);
            frame.setLocationRelativeTo(null); // Center on screen

            frame.add(new RegisterPanel());

            frame.setVisible(true);
        });
    }
}
