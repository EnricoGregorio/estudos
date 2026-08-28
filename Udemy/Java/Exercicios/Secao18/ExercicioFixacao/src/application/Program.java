package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> employees = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(",");
                employees.add(new Employee(data[0], data[1], Double.parseDouble(data[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            List<String> emails = employees.stream()
                    .filter(employee -> employee.getSalary() > salary)
                    .map(employee -> employee.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("E-mail of people whose salary is more than " + String.format("%.2f", salary) + ":");
            emails.forEach(System.out::println);

            double sum = employees.stream()
                    .filter(employee -> employee.getName().charAt(0) == 'M')
                    .map(employee -> employee.getSalary())
                    .reduce(0.0, (emp1, emp2) -> emp1 + emp2);

            System.out.print("Sum of salary of the people whose name starts with 'M': " + String.format("%.2f", sum));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
