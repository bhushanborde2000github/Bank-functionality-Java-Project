package Banking;

import java.util.Scanner;

public  class OpenAccount {
    String name;
    int accountNum;
    String accountType;
    String dob;
    String bank;
    String IFSC;

    public void creatAccount() {
        Scanner sc=new Scanner(System.in);

        System.out.println("In which Bank you want to open an account : 1.SBI 2.BOI 3.IDBI 4.HDFC");
        int choiceBank = sc.nextInt();
        if (choiceBank == 1){
            bank ="SBI";
            IFSC ="SBIN0007671";
        }
        if (choiceBank == 2){
            bank = "BOI";
            IFSC ="ICIC0000059";
        }
        if (choiceBank == 3){
            bank ="IDFC";
            IFSC ="IDFB0042501";
        }
        if (choiceBank == 4){
            bank ="HDFC";
            IFSC ="HDFC0001248";
        }
        System.out.println("Please enter your name : ");
        sc.nextLine();
        name= sc.nextLine();

        System.out.println("Please enter your date of birth : ");
        dob = sc.nextLine();

        System.out.println("What type of account you want to open : 1.Saving  2.Current");
        int choice =sc.nextInt();
        if (choice == 1){
            accountType ="Saving";
        }
        if (choice == 2){
            accountType = "Current";
        }
        System.out.println("Your account has been  opened with following details ");
        System.out.println("Bank : "+bank);
        System.out.println("Name : "+name);
        System.out.println("DOB : "+dob);
        System.out.println("Account Type : "+accountType);
        System.out.println("Account Number : "+ Math.random());
        System.out.println("IFSC code : "+IFSC);

        System.out.println("\n");

        BankAccount obj1= new BankAccount();
        obj1.showMenu();
        sc.close();
    }
}


