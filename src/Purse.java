import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.HashSet;
import java.util.Set;


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

        notifyObservers();

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

        notifyObservers();

        return 0.0;

    }

    //Couldn't get it to display right using get value for the list of denominations and the total value so added this class
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    //Returns the amount of money in the Purse
    public double getValue()
    {
        int pennyFix=0;
        double total = 0.0;

        for (Map.Entry<Denomination, Integer> entry : cash.entrySet())
        {
            pennyFix+= (int) Math.round(entry.getKey().amt()*100)*entry.getValue();
        }

        return pennyFix/100.0;
    }

    //Returns a string representation of the Purse and its contents
    @Override
    public String toString()
    {
        //Convert to a List so I can sort it
        List<Map.Entry<Denomination, Integer>> list = new ArrayList<>(cash.entrySet());

        //Sort by value for a better look
        list.sort(Comparator.comparingDouble(e-> -e.getKey().amt()));

        //If empty
        if (getValue() < 0.005) {
           return "Empty Purse";
        }

        String contents = "Purse Contains: \n";

        for (Map.Entry<Denomination, Integer> entry : list)
        {
            contents += entry.getValue() + ": " + entry.getKey().name() + "\n";

        }

        //Fix rounding penny problem
        int total = (int) Math.round(getValue()*100);
        double roundedTotal = total/100.0;


        //Add total value to string and format it for better look
        contents += String.format("Total: $%.2f\n", roundedTotal);

        return contents;

    }

    private final Set<PurseObserver> observers = new HashSet<>();

    public void addObserver(PurseObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PurseObserver observer) {
        observers.remove(observer);
    }

    // Pull update: just notifies observers that something changed
    private void notifyObservers() {
        for (PurseObserver observer : observers) {
            observer.update(this); // they pull state using this
        }
    }

}
