//Project : Number Guessing Game
//Developed By : Raghav Patidar

import java.util.Random;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        System.out.println("#####################################################");
        System.out.println("Welcome to Number Guessing Game.");
        System.out.println();
        System.out.println("You will get 3 attempts to guess the correct number.");
        System.out.println("#####################################################\n");

        Scanner input = new Scanner(System.in);
        Random randObj = new Random();
        int attempts = 3;
        //generating random number
        int random_number = randObj.nextInt(1,101);
        while(attempts > 0)
        {
            System.out.print("Enter a number : ");
            int user_entered_number = input.nextInt();
            if (user_entered_number == random_number)
            {
                System.out.println("\nCongratulations!!!You guessed it right.");
                break;
            }
            if (random_number > user_entered_number)
            {
                System.out.println("\nHint: The correct number is greater than "+user_entered_number+"\n");
            }
            if(random_number < user_entered_number) {
                System.out.println("\nHint: The correct number is lesser than " + user_entered_number);
            }
            attempts -= 1;
            if(attempts == 0)
            {
                System.out.println("No attempts left!!!");
            }
            else{
                System.out.println("Attempts left : "+ attempts);
            }
            System.out.println();
        }
        System.out.println("##############################################");
        System.out.println("Your score is "+(attempts * 5)+" points.");
        System.out.println("The correct number is "+random_number);
        System.out.println("##############################################");

    }
}
