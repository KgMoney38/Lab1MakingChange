import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Done.

public class Register
{

    private static final List<Denomination> Denominations = Arrays.asList(
            new Denomination("Hundred Dollar Bill", 100.0, "bill", "hundred.png"),
            new Denomination("Fifty Dollar Bill", 50.0, "bill", "fifty.png"),
            new Denomination("Twenty Dollar Bill", 20.0, "bill", "twenty.png")  ,
            new Denomination("Ten Dollar Bill(s)", 10.0, "bill", "ten.png"),
            new Denomination("Five Dollar Bill(s)", 5.0, "bill", "five.png"),
            new Denomination("Dollar Bill(s)", 1.0, "bill", "dollar.png"),
            new Denomination("Quarter", .25, "coin", "quarter.png"),
            new Denomination("Dime", .1, "coin", "dime.png"),
            new Denomination("Nickel", .05, "coin", "nickel.png"),
            new Denomination("Penny", .01, "coin", "penny.png")
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
