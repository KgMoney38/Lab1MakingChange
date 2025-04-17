//NEW for my lab 4
//Strategy interface for creating the change from the dollar amount entered
public interface ChangeStrategy
{
    //Returns the purse with the change amount
    Purse makeChange(double amount);
}
