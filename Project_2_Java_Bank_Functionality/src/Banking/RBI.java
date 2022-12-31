package Banking;


import java.util.Scanner;

public class RBI {

    public static void main(String[] args) {


        System.out.println("---------------------------Welcome to the Banking Portal------------------------------");
        System.out.println("Do you want to Open an account : 1.Yes 2.No ");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Yes")) {
            OpenAccount obj = new OpenAccount();
            obj.creatAccount();
        }
        if (choice.equalsIgnoreCase("No")) {
            BankAccount obj1 = new BankAccount();
            obj1.showMenu();
        }
    }

}