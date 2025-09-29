package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        Account account;

        int number;
        String holder;
        char response;
        double depositValue, withdrawValue;

        System.out.print("Enter account number: ");
        number = in.nextInt();

        System.out.print("Enter account holder: ");
        in.nextLine();
        holder = in.nextLine();

        System.out.print("Is there an initial deposit(y/n)? ");
        response = in.next().charAt(0);

        if(response == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = in.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder);
        }

        System.out.println("\nAccount Data:\n" + account);
        System.out.print("\nEnter a deposit value: ");
        depositValue = in.nextDouble();
        account.deposit(depositValue);
        System.out.println("\nUpdated account data:\n" + account);

        System.out.print("\nEnter a withdraw value: ");
        withdrawValue = in.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("\nUpdated account data:\n" + account);

        in.close();
    }
}
