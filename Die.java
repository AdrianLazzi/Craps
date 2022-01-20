
/**
 * Write a description of class Die here.
 *
 * @author Adrian Lazzi
 * @version 2022-01-18
 */
public class Die
{
    // instance variables - replace the example below with your own
    private int roll;

    /**
     * Constructor for objects of class Die
     */
    public Die()
    {
        // initialise instance variables
        roll = dieRoll();
    }

    /**
     * int dieRoll method returns the roll of a dice
     * @return roll the roll
     */
    public int dieRoll()
    {
        roll = (int) (Math.random() * 6) + 1;
        return roll;
    }
    /**
     * int getRoll gets the roll
     * @return roll the roll
     */
    public int getRoll()
    {
        // put your code here
        return roll;
    }
}
