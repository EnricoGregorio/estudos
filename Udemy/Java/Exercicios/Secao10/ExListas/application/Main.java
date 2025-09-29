package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        List<Employee> employee = new ArrayList<>();

        // READING DATA:

        System.out.print("How many employees will be registered? ");
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("%nEmployee #%d: %n", i);
            
            System.out.print("ID: ");
            int id = in.nextInt();

            while (hasID(employee, id)) {
                System.out.println("ID alred ytaken. Try again: ");
                id = in.nextInt();
            }

            in.nextLine();

            System.out.print("Name: ");
            String name = in.nextLine();

            System.out.print("Salary: ");
            double salary = in.nextDouble();

            employee.add(new Employee(id, name, salary));
        }

        // UPDATING SALARY OF GIVEN EMPLOYEE:

        System.out.print("\nEnter the employee id that will have salary increase: ");
        int id = in.nextInt();
        
        Employee emp = employee.stream().filter(x -> x.getID() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This ID does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = in.nextDouble();
            emp.increaseSalary(percentage);
        }

        // LISTING EMPLOYEES:

        System.out.println("\nList of employees:");
        for (Employee obj : employee) {
            System.out.println(obj);
        }

        in.close();
    }

    public static boolean hasID(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getID() == id).findFirst().orElse(null);
        return emp != null;
    }
}
