import javax.swing.*;
import java.util.Scanner;

//Done.

public class MakingChange
{
    public static void main(String[] args)
    {

            JFrame frame = new JFrame("Making Change");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);

            frame.add(new RegisterPanel());
            frame.setVisible(true);

            char repeat = ' ';

            //Do while loop to help the reviewers out so they don't have to
            //relaunch every time they need to test a value in the console window
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the amount: ");
                double amt = scanner.nextDouble();

                Register register = new Register();
                //double amt = 338.38;
                Purse change = register.makeChange(amt);
                System.out.println("Making change for: $" + amt);

                System.out.println(change);
                System.out.println("Repeat? Any key for yes/ N||n for no");
                repeat = scanner.next().charAt(0);

            }while (repeat != 'n'|| repeat != 'N');

    }
}
