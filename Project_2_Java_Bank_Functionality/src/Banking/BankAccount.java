package Banking;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public  class BankAccount {
    static int balance;
    int previousTransaction;
    String customerName;
    static String accountType;
    String accountId;
    static double totalInterest;
    void calculateInterest(double balance){
        System.out.println("What type of account you : 1.Saving 2.Current ");
        Scanner sc=new Scanner(System.in);
        int choice =sc.nextInt();

        if (choice == 1) {
            accountType = "Saving";
            int r = 5;
            int t;
            System.out.println("Enter year to calculate interest : ");
            t = sc.nextInt();

            double finalAmount = balance * (1 + r * t);

            totalInterest = finalAmount - balance;
            System.out.println("Total interest earned is :" + totalInterest);

        }
        if (choice == 2){
            accountType ="Current";
            int r = 8;
            int t,n;
            System.out.println("Enter year to calculate interest");
            t=sc.nextInt();
            System.out.println("Enter the frequency that interest has been compound in a year  ");
            n=sc.nextInt();

            double finalAmount = balance *(Math.pow((1+r/n),n*t));

            totalInterest = finalAmount -balance;
            System.out.println("Total interest earned is : "+totalInterest);
            sc.close();
        }

    }
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            System.out.println("Balance after Deposit : "+balance);
            previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if (amount != 0){
            balance = balance -amount;
            System.out.println("Balance after Withdraw : "+balance);
            previousTransaction = -amount;

        }
    }
    void  getPreviousTransaction(){
        FileOutputStream out;
        PrintStream p;
        try {
           out= new FileOutputStream("C:\\Users\\ajink\\eclipse-workspace\\java\\Projrct2\\src\\Passbook");
            p=new PrintStream(out);
            if (previousTransaction >0){
                p.append("Deposited : ").append(String.valueOf(previousTransaction));
                System.out.println("Deposited : "+previousTransaction);
            } else if (previousTransaction <0) {
                p.append("Withdrawn : ").append(String.valueOf(previousTransaction));
                System.out.println("Withdrawn : "+Math.abs(previousTransaction));

            }else {
                System.out.println("No Transaction occurred ");
            }
            p.close();
        }catch (Exception e){
            System.out.println("Error in printing the data "+ e);
        }
    }

    void showMenu(){
        char option ='\0';
        Scanner sc =new Scanner(System.in);
        System.out.println("Welcome to the menu ");
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit Amount");
        System.out.println("C. Withdraw amount");
        System.out.println("D. See Previous transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");
        do {
            System.out.println("###################################");
            System.out.println("Enter an option");
            System.out.println("###################################");
            option=sc.next().charAt(0);
            System.out.println("\n");
            switch (option){
                case 'A':
                    System.out.println("__________________________");
                    System.out.println("Balance = "+balance);
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("__________________________");

                    System.out.println("Enter an amount to deposit : ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw :");
                    amount = sc.nextInt();
                   withdraw(amount);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("____________________________");
                    getPreviousTransaction();
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("_____________________________");
                    calculateInterest(balance);
                    System.out.println("\n");
                    break;
                case 'F':
                    System.out.println("______________________________");
                    break;
                default:
                    System.out.println("Entered Invalid Option....! .Please enter Again");
                    break;

            }
        }while (option != 'F');
        System.out.println("Thank You for using our services");
    }
}

