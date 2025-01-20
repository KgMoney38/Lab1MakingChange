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

    public Purse makeChange(double amt)
    {
        Purse purse = new Purse();
        for (Denomination d : Denominations)
        {
            int count = (int) (amt / d.amt());
            if (count > 0)
            {
                purse.add(d, count);
                amt -= count * d.amt();
            }
        }

        return purse;
    }
}
