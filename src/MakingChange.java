import javax.swing.*;
import java.util.Scanner;

public class MakingChange {
    public static void main(String[] args) {
        // Console input for testing purposes
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        double amt = scanner.nextDouble();

        // Create strategy and register
        ChangeStrategy strategy = new GreedyChangeStrategy(DenominationFactory.createAll());
        Register register = new Register(strategy);

        // Make change and get a purse
        Purse purse = register.makeChange(amt);

        // GUI setup
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        PursePanel panel = new PursePanel(purse); // Observer pulls from purse
        frame.add(panel);

        frame.setVisible(true);

        // Console log (optional)
        System.out.println("Making change for: $" + amt);
        System.out.println(purse);
    }
}
