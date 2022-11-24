//Project Name : ATM Interface
//Developed By : Raghav Patidar

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //prompting user for userid and pin
        System.out.println("Welcome to Banking Application");
        System.out.println();
        System.out.print("Enter Your User Id : ");
        int userId = input.nextInt();
        System.out.print("Enter Your Pin : ");
        int userPin = input.nextInt();
        System.out.println();

        //balance available in user's bank account
        float current_balance = 50000;
        float amount = 0;

        //user can see the transaction_history
        ArrayList <String> transaction_history = new ArrayList<String>();
        String transfer_to;
        //performing banking operations
        int choice = 0;
        while(choice != 5)
        {
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer Money");
            System.out.println("5. Quit");
            System.out.println();
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            System.out.println();

            if(choice == 1)
            {
                if(transaction_history.size() == 0)
                {
                    System.out.println("You have not made any transactions yet.");
                }
                else{
                    System.out.println("Recent Transactions :");
                    System.out.println();
                    for(String transaction:transaction_history)
                    {
                        System.out.println(transaction);
                    }
                }
                System.out.println();
            }
            else if(choice == 2)
            {
                //withdraw money from bank account
                amount = getInput("withdraw", current_balance);
                if(current_balance < amount)
                {
                    System.out.println("Insufficient Funds!!!");
                }
                else{
                    current_balance -= amount;
                    transfer_to = "UTIR0555/155532412/self \t\t\t debited by \t\t\t"+"₹ "+amount ;
                    transaction_history.add(transfer_to);
                    System.out.println("Balance available after withdrawal : "+current_balance);
                }
                System.out.println();
            }
            else if(choice == 3)
            {
                //deposit money in bank account
                amount = getInput("deposit", current_balance);
                current_balance += amount;
                transfer_to = "UTIR0555/155532412/self \t\t\t credited by \t\t\t"+"₹ "+amount ;
                transaction_history.add(transfer_to);
                System.out.println("Balance available after deposit : "+current_balance);
                System.out.println();
            }

            else if(choice == 4)
            {
                //Transfer money to other bank account
                System.out.print("Enter Account Holder Name : ");
                String account_holder_name = input.next();
                System.out.println();
                String account_number;
                while(true)
                {
                    System.out.print("Enter Account Number : ");
                    account_number = input.next();
                    //checking if account number length is 9 digit or not
                    if(account_number.length() != 9)
                    {
                        System.out.println("Please Enter Valid 9 Digit Account Number!!!\n");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Enter IFSC code : ");
                String ifsc_code = input.next();
                amount = getInput("transfer", current_balance);
                if(current_balance < amount)
                {
                    System.out.println("\nInsufficient Funds!!!");
                }
                //transferring and adding the operation in transaction history
                else{
                    current_balance -= amount;
                    transfer_to = ifsc_code+"/"+account_number+"/"+account_holder_name+"/self \t\t debited by \t\t\t"+"₹ "+amount ;
                    transaction_history.add(transfer_to);
                    System.out.println(amount+" has been credited into "+account_holder_name+" account.");
                }
                System.out.println();
            }
            else if(choice == 5)
            {
                System.out.println("Thank you for banking with us.");
            }
            else{
                System.out.println("\nInvalid Choice!!!\n");
            }
        }

    }

    public static float getInput(String choice, float current_balance)
    {
        System.out.println("Available Balance : "+current_balance);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount you want to "+choice+" : ");
        float amount = input.nextFloat();
        return amount;
    }

}
