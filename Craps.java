
/**
 * Write a description of class Craps here.
 *
 * @author Adrian Lazzi
 * @version 01-09-2022
 */
import java.util.Scanner;
public class Craps
{
    
    /**
     * int rollDie finds the sum of two die rolls
     * @param roll1 the first die roll
     * @param roll2 the second die roll
     * @return roll1 + roll2
     */
    public static int rollDie(Die roll1, Die roll2)
    {
        
        roll1.dieRoll();
        roll2.dieRoll();
        
        return roll1.getRoll() + roll2.getRoll();
    }
    
    /**
     * void instructions prints Craps instructions
     */
    public static void instructions(String instructions)
    {
        
        
        if (instructions.equals("") || instructions.substring(0, 1).equalsIgnoreCase("y"))
        {
            System.out.println("1. You will roll two six-sided dice and add the results together.");
            System.out.println("2. On the first roll, a 7 or an 11 automatically wins, and a 2, 3, or 12 automatically loses, and play is over.");
            System.out.println("If a 4, 5, 6, 8, 9, or 10 are rolled on the first roll, that number becomes the \"point\", and you will roll the two die until the sum equals 4 (win) or 7 (lose).");
        }
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int wins = 0;
        int losses = 0;
        int roundsPlayed = 0;
        
        System.out.print("Would you like to play Craps (yes/no)? ");
        String playGame = in.nextLine();
        while (playGame.equals("") || playGame.substring(0, 1).equalsIgnoreCase("y"))
        {  
            roundsPlayed++;
            System.out.println("-------------------------------- Round " + roundsPlayed + "----------------------------------");
            if (roundsPlayed == 1)
            {
                System.out.print("Would you like instructions on how to play the game (yes/no)? ");
                String wouldLike = in.nextLine();
                instructions(wouldLike);
            }
            else
            {
                System.out.print("Do you need a reminder of how to play the game (yes/no)? ");
                String wouldLike = in.nextLine();
                instructions(wouldLike);
            }
            Die roll1 = new Die(), roll2 = new Die();
            System.out.print("Press enter to roll the die: ");
            String pressed = in.nextLine();
            int sum = 0;
            if (pressed.equals("")) 
            { 
                sum = rollDie(roll1, roll2);
                System.out.println("You rolled: " + sum);
            }
            
            if (sum == 7 || sum == 11)
            {
                wins++;
                System.out.println("You won!");
                System.out.println("You have won " + wins + " out of " + roundsPlayed + " total rounds played.");
                System.out.print("Would you like to play again (yes/no)? ");
                playGame = in.nextLine();
                
            }
            else if (sum == 2 || sum == 3 || sum == 12)
            {
                losses++;
                System.out.println("Ouch! You lost.");
                System.out.println("You have lost " + losses + " out of " + roundsPlayed + " total rounds played.");
                System.out.print("Would you like to give it another shot (yes/no)? ");
                playGame = in.nextLine();
            }
            else
            {
                System.out.println("That is your point.\nLets see if you can roll it again before you roll a 7!");
                int newRoll = 0;
                while (newRoll != 7 && newRoll != sum)
                {
                    System.out.print("Press enter to roll again: ");
                    String rollAgain = in.nextLine();
                    if (rollAgain.equals(""))
                    {
                        newRoll = rollDie(roll1, roll2); 
                    }
                    System.out.println("You rolled a "+ newRoll);
                } 
                
                if (newRoll == sum) 
                {
                    wins++;
                    System.out.println("Congratulations!, you hit your point!");
                    System.out.println("You have won " + wins + " out of " + roundsPlayed + " total rounds played.");
                    System.out.print("Would you like to play again (yes/no)? ");
                    playGame = in.nextLine();
                }
                else 
                {
                    losses++;
                    System.out.println("Darn! You landed on a seven.");
                    System.out.println("You have lost " + losses + " out of " + roundsPlayed + " total rounds played.");
                    System.out.print("Would you like to give it another shot (yes/no)? ");
                    playGame = in.nextLine();
                }
            }
            
        }
        System.out.println("-------------------------------- Thanks for playing! ----------------------------------");
        System.out.print("Would you like to see your results (yes/no)? ");
        String seeResults = in.nextLine();
        if (seeResults.equals("") || seeResults.substring(0, 1).equalsIgnoreCase("y"))
        {
            System.out.println("You have played " + roundsPlayed + " total round(s). Out of those, you have won " + wins + " time(s) and lost " + losses + " time(s).");
        }
        
    }
}
