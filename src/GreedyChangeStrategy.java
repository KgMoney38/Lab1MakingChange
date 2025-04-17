import java.util.List;

//This class makes change using my greedy algorithm strategy
//Basically always use the largest denomination possible first and continue tha pattern until the final amount is reached
public class GreedyChangeStrategy implements ChangeStrategy
{
    //List of my denominations
    private final List<Denomination> denominations;

    public GreedyChangeStrategy(List<Denomination> denominations) {
        this.denominations = denominations;
    }

    //Returns the change using the fewest number of bills and coins
    @Override
    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        int totalCents = (int) Math.round(amt * 100);

        for (Denomination d : denominations) {
            int denomCent = (int) Math.round(d.amt() * 100);
            int count = totalCents / denomCent;
            if (count > 0) {
                purse.add(d, count);
                totalCents -= count * denomCent;
            }
        }

        return purse;
    }
}
