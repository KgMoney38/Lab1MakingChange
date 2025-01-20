import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Done.

public class Purse {

    //Denomination is the key, Integer is the value
    private Map<Denomination, Integer> cash;

    //Constructor
    public Purse()
    {
        cash = new HashMap<>();
    }

    public void add(Denomination type, int num)
    {
            //Couldn't gt it to work without getOrDefault
            cash.put(type, cash.getOrDefault(type,0) + num);

    }

    public double remove(Denomination type, int num)
    {
        if (cash.containsKey(type) && cash.get(type) >= num)
        {
            cash.put(type, cash.get(type)- num);

            if (cash.get(type) == 0) {
                cash.remove(type);
            }

            return type.amt() * num;
        }
        return 0.0;
    }

    //Couldn't get it to display right using get value for the list of denominations and the total value so added this class
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    public double getValue()
    {
        double total = 0.0;
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet())
        {
            total+= entry.getKey().amt() * entry.getValue();
        }
        return total;
    }

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
