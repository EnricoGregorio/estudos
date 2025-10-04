package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        // Informando o nome do departamento:
        System.out.print("Enter department's name: ");
        String departmentName = in.nextLine();

        // Informando os dados do trabalhador:
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = in.nextLine();

        System.out.print("Level: ");
        String workerLevel = in.nextLine();

        System.out.print("Base salary: ");
        double baseSalary = in.nextDouble();

        // Instanciando UM novo trabalhador, de acordo com os dados informados e vinculando ele à UM departamento:
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int nContracts = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= nContracts; i++) {
            System.out.printf("Enter contract #%d data:%n", i);

            System.out.print("Date (DD/MM/YYYY): ");
            String contractDate = in.nextLine();
            LocalDate contractDateFormatted = LocalDate.parse(contractDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Value per hour: ");
            double valuePerHour = in.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = in.nextInt();
            in.nextLine();
            // Instanciando UM contrato, com as informações inseridas:
            HourContract contract = new HourContract(contractDateFormatted, valuePerHour, hours);

            // Vinculando CADA contrato ao trabalhador:
            worker.addContract(contract);
        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String income = in.nextLine();
        YearMonth incomeFormatted = YearMonth.parse(income, DateTimeFormatter.ofPattern("MM/yyyy"));
        int incomeMonth = incomeFormatted.getMonthValue();
        int incomeYear = incomeFormatted.getYear();

        System.out.print("Name: " + worker.getName().toString());
        System.out.print("\nDepartment: " + worker.getDepartment().getName());
        System.out.printf("\nIncome for %s: %.2f%n", income, worker.income(incomeMonth, incomeYear));

        in.close();
    }
}
