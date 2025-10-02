import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

void main() {
    Scanner in = new Scanner(System.in);

    System.out.println("Enter client data:");
    System.out.print("Name: ");
    String name = in.nextLine();

    System.out.print("E-mail: ");
    String email = in.nextLine();

    System.out.print("Birth date (DD/MM/YYYY): ");
    String date = in.nextLine();
    LocalDate dateFormatted = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    Client client = new Client(name, email, dateFormatted);

    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    OrderStatus status = OrderStatus.valueOf(in.next());

    Order order = new Order(LocalDateTime.now(), status, client);

    System.out.print("How many items to this order? ");
    int itemsOrder = in.nextInt();
    in.nextLine();

    for (int i = 1; i <= itemsOrder; i++) {
        System.out.printf("Enter #%d item data:%n", i);
        System.out.print("Product name: ");
        String prodName = in.nextLine();

        System.out.print("Product price: ");
        double prodPrice = in.nextDouble();

        System.out.print("Quantity: ");
        int itemQuantity = in.nextInt();
        in.nextLine();

        Product product = new Product(prodName, prodPrice);
        OrderItem items = new OrderItem(itemQuantity, product.getPrice(), product);
        order.addItem(items);
    }

    System.out.println("\nORDER SUMMARY:\n" + order);

    in.close();
}