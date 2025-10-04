import entities.Company;
import entities.Individual;
import entities.TaxPayer;

void main() {
    Scanner in = new Scanner(System.in);

    List<TaxPayer> taxPayers = new ArrayList<>();

    System.out.print("Enter the number of tax payers: ");
    int numTaxPayers = in.nextInt();

    for (int i = 1; i <= numTaxPayers; i++) {
        System.out.printf("Tax payer #%d data:%n", i);
        System.out.print("Individual or company (i/c)? ");
        char type = in.next().charAt(0);
        in.nextLine();

        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("Anual income: ");
        double anualIncome = in.nextDouble();

        if (type == 'i') {
            System.out.print("Health expenditures: ");
            double healthExpenditures = in.nextDouble();
            taxPayers.add(new Individual(anualIncome, name, healthExpenditures));
        } else {
            System.out.print("Number of employees: ");
            int numberOfEmployees = in.nextInt();
            taxPayers.add(new Company(anualIncome, name, numberOfEmployees));
        }
    }

    System.out.println("\nTAXES PAID:");
    for(TaxPayer taxPayer : taxPayers) {
        System.out.printf("%s: $ %.2f%n", taxPayer.getName(), taxPayer.tax());
    }

    in.close();
}