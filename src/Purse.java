import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Done.

public class Purse {

    //Denomination is the key, Integer is the value
    //Represents the money in the purse
    private Map<Denomination, Integer> cash;

    //Constructor
    public Purse()
    {
        cash = new HashMap<>();
    }

    //Adds a number of a particular denomination
    public void add(Denomination type, int num)
    {
        //To get my pennie displayed right
        if(type.amt() == 0.01)
        {
            num= (int) Math.ceil(num);
        }
            //Couldn't gt it to work without getOrDefault
            cash.put(type, cash.getOrDefault(type,0) + num);

    }

    //Diminishes the money in the purse and returns that amount.
    public double remove(Denomination type, int num)
    {
        if (cash.containsKey(type))
        {
            int available = cash.get(type);
            int remove = Math.min(num, available);
            cash.put(type, available- remove);

            if (cash.get(type) == 0)
            {
                cash.remove(type);
            }

            return type.amt() * remove;
        }
        return 0.0;
    }

    //Couldn't get it to display right using get value for the list of denominations and the total value so added this class
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    //Returns the amount of money in the Purse
    public double getValue()
    {
        double total = 0.0;
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet())
        {
            total+= entry.getKey().amt() * entry.getValue();
        }
        return total;
    }

    //Returns a string representation of the Purse and its contents
    @Override
    public String toString() {
        return cash.entrySet().stream()
                //REMEMBER THIS FOR SORTING!
                //THE ONLY WAY I COULD GET THE CURRENCY TO DISPLAY FROM GREATEST TO LEAST
                .sorted(Comparator.comparingDouble((Map.Entry<Denomination, Integer> e) -> e.getKey().amt()).reversed())
                .map(entry -> entry.getValue() + " " + entry.getKey().name())
                .reduce("Purse Contains:\n", (a, b) -> a + b + "\n")
                + "Total: $ " + BigDecimal.valueOf(getValue()).setScale(2, RoundingMode.HALF_UP);

    }
}
