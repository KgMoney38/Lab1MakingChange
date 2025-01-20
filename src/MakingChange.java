import javax.swing.*;
import java.util.Scanner;

//Done.

public class MakingChange
{
    public static void main(String[] args)
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the amount: ");
    double amt = scanner.nextDouble();
    Register register = new Register();
    //double amt = 338.38;
    Purse change = register.makeChange(amt);
    System.out.println("Making change for: $" + amt);
    System.out.println(change);

        JFrame frame= new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);

        frame.add(new RegisterPanel());
        frame.setVisible(true);
    }
}
