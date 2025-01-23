import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Done.

public class Register
{

    private static final List<Denomination> Denominations = Arrays.asList(
            new Denomination("Hundred Dollar Bill(s)", 100.0, "bill", "hundred"),
            new Denomination("Fifty Dollar Bill(s)", 50.0, "bill", "fifty"),
            new Denomination("Twenty Dollar Bill(s)", 20.0, "bill", "twenty")  ,
            new Denomination("Ten Dollar Bill(s)", 10.0, "bill", "ten"),
            new Denomination("Five Dollar Bill(s)", 5.0, "bill", "five"),
            new Denomination("Dollar Bill(s)", 1.0, "bill", "dollar"),
            new Denomination("Quarter(s)", .25, "coin", "quarter"),
            new Denomination("Dime(s)", .1, "coin", "dime"),
            new Denomination("Nickel(s)", .05, "coin", "nickel"),
            new Denomination("Penny", .01, "coin", "penny")
    );

    //Takes an amt and returns a Purse containing
    //that amount in the fewest number of bills and coins.
    public Purse makeChange(double amt)
    {
        Purse purse = new Purse();
        int totalCents = (int) Math.round(amt * 100);

        for (Denomination d : Denominations)
        {
            int denomCent = (int) Math.round(d.amt()*100);
            int count = totalCents/ denomCent;
            if (count > 0)
            {
                purse.add(d, count);
                totalCents -= count * denomCent;
            }
        }

        return purse;
    }

    //Creates a Register and demonstrates that it works.
    static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount: ");

        if(!scanner.hasNextDouble())
        {
            System.out.println("Invalid input");
            return;
        }

        double amt = scanner.nextDouble();
        Register register = new Register();
        Purse purse = register.makeChange(amt);

        System.out.println("Change for: $" + amt);
        System.out.println(purse);
    }
}
