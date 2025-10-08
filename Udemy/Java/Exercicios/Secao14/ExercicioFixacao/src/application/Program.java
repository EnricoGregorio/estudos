import model.entities.Account;
import model.exceptions.DomainException;

void main() {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter account data:");
    System.out.print("Number: ");
    int number = in.nextInt();
    in.nextLine();

    System.out.print("Holder: ");
    String holder = in.nextLine();

    System.out.print("Initial balance: ");
    double initialBalance = in.nextDouble();

    System.out.print("Withdraw limit: ");
    double withdrawLimit = in.nextDouble();

    Account account = new Account(number, holder, initialBalance, withdrawLimit);

    System.out.print("Enter amount for withdraw: ");
    double withdraw = in.nextDouble();

    try {
        account.withdraw(withdraw);
        System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
    } catch (DomainException e) {
        System.out.println("Withdraw error: " + e.getMessage());
    }

    in.close();
}