package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Employer;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        Employer employer = new Employer();
        double tax;


        System.out.print("Name: ");
        employer.name = in.nextLine();
        System.out.print("Gross salary: ");
        employer.grossSalary = in.nextDouble();
        System.out.print("Tax: ");
        employer.tax = in.nextDouble();

        System.out.printf("%n%s, $ %.2f%n", employer.name, employer.netSalary());

        System.out.print("\nWhich percentage to increase salary? ");
        tax = in.nextDouble();
        employer.increaseSalary(tax);

        System.out.printf("\nUpdated data: %s, $ %.2f%n", employer.name, employer.netSalary());

        in.close();
    }
}
