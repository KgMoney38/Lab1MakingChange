import java.util.List;

//The strategy used to make change
public class Register {
    private final ChangeStrategy strategy;

    //Sets the strategy for making change
    public Register(ChangeStrategy strategy) {
        this.strategy = strategy;
    }

    //Returns the change for the amount entered
    public Purse makeChange(double amount) {
        return strategy.makeChange(amount);
    }
}
