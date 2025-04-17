import java.util.List;

public class Register {
    private final ChangeStrategy strategy;

    public Register(ChangeStrategy strategy) {
        this.strategy = strategy;
    }

    public Purse makeChange(double amount) {
        return strategy.makeChange(amount);
    }
}
