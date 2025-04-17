import java.util.Arrays;
import java.util.List;

public class DenominationFactory
{
    public static List<Denomination> createAll() {
        return Arrays.asList(
                new Denomination("Hundred Dollar Bill(s)", 100.0, "bill", "hundred"),
                new Denomination("Fifty Dollar Bill(s)", 50.0, "bill", "fifty"),
                new Denomination("Twenty Dollar Bill(s)", 20.0, "bill", "twenty"),
                new Denomination("Ten Dollar Bill(s)", 10.0, "bill", "ten"),
                new Denomination("Five Dollar Bill(s)", 5.0, "bill", "five"),
                new Denomination("Dollar Bill(s)", 1.0, "bill", "dollar"),
                new Denomination("Quarter(s)", .25, "coin", "quarter"),
                new Denomination("Dime(s)", .10, "coin", "dime"),
                new Denomination("Nickel(s)", .05, "coin", "nickel"),
                new Denomination("Penny", .01, "coin", "penny")
        );
    }
}
