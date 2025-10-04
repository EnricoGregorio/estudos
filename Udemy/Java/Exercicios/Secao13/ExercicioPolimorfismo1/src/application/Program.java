import entities.Employee;
import entities.OutsorcedEmployee;

void main() {
    Scanner in = new Scanner(System.in);

    List<Employee> employees = new ArrayList<>();

    System.out.print("Enter the number of employees: ");
    int numberEmployees = in.nextInt();
    in.nextLine();

    for (int i = 1; i <= numberEmployees; i++) {
        System.out.printf("Employee #%d data:%n", i);
        System.out.print("Outsourced (y/n)? ");
        char isOutsourced = in.next().charAt(0);
        in.nextLine();

        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("Hours: ");
        int hours = in.nextInt();

        System.out.print("Value per hour: ");
        double valuePerHour = in.nextDouble();

        if (isOutsourced == 'y') {
            System.out.print("Additional charge: ");
            double additionalCharge = in.nextDouble();
            employees.add(new OutsorcedEmployee(name, hours, valuePerHour, additionalCharge));
        } else {
            employees.add(new Employee(name, hours, valuePerHour));
        }
        in.nextLine();
    }

    System.out.println("\nPAYMENTS:");
    for (Employee emp : employees) {
        System.out.println(emp);
    }

    in.close();
}