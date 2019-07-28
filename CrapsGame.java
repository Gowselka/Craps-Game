
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gowse
 */
public class CrapsGame {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       
        boolean done = false;
        int userValue = 0;
        int crapsRoll = 0; //Gaussian range from 2 to 12 as in rolling two dice. 
        int scoreNew = 0;
        int point = 0;
        
        
        while(!done)
        {
            System.out.println("");
            System.out.println("WELCOME TO THE GAME OF CRAPS!");
            System.out.println("_____________________________________________");
            //prompt the user to play to game
            System.out.println("Would you like to roll the dice? ");
            System.out.print("Enter 1 to roll or 2 to exit: ");

            //bullet proof user input 
            userValue = getInt();
            
            //roll the dice or exit
            if(userValue==1)
            {
                crapsRoll = Rolls();
            }
            else
            {
                done = true;
                System.exit(0);
            }
            
            //game intreprets the rolls 
            if(crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
            {
                System.out.println("Oops! Looks like you crapped out. You lose. ");
                done = true;
                System.exit(0);
            }
            if(crapsRoll == 7 || crapsRoll == 11)
            {
                System.out.println("Yay! You got a natural win!");
                done = true;
                System.exit(0);
            }
            else
            {
                System.out.println("Looks like your roll was " + crapsRoll);
                System.out.println("Looks like you roll again. Try to get your point roll of " + crapsRoll);
            }
            
            point = crapsRoll;
            
                do
                {
                    scoreNew = Rolls();
                    System.out.println("\n Your new roll is: " + scoreNew);

                    if(scoreNew == point)
                    {
                        System.out.println("You got point! you win!");
                        done = true;
                        System.exit(0);
                    }
                    if(scoreNew ==7)
                    {
                        System.out.println("\n Looks like you lost. ");
                        done = true;
                        System.exit(0);
                    }
                }
                while (scoreNew != point || scoreNew !=7 );

        }
    }
    public static int getInt()
    {
        int inputValue = 0;
        boolean done = false;
        String trash;
        
        while(!done)
        {
            if(in.hasNextInt())
            {
                inputValue = in.nextInt();
              
            }
            if(inputValue==1 || inputValue==2)
            {
                done = true;
            }
            else
            {
                trash = in.nextLine();
                System.out.print("Please enter a valid number. Try again: ");
            }
        }
        return inputValue;
    }
    
    public static int Rolls()
    {
            Random rnd = new Random();
            int dieA = rnd.nextInt(6)+1;
            int dieB = rnd.nextInt(6)+1;
            int score = dieA + dieB;
            
            System.out.println("Your first result is: " + dieA);
            System.out.println("Your second die result is: " + dieB);
            System.out.println("The sum of your rolls is: " + score);
            
            return score;
    }
    
}
