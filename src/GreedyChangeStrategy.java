import java.util.List;

public class GreedyChangeStrategy implements ChangeStrategy
{
    private final List<Denomination> denominations;

    public GreedyChangeStrategy(List<Denomination> denominations) {
        this.denominations = denominations;
    }

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
