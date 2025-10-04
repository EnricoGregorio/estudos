package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numProducts = in.nextInt();

        for (int i = 1; i <= numProducts; i++) {
            System.out.printf("Product #%d data:%n", i);

            System.out.print("Common, used, or imported (c/u/i)? ");
            char productType = in.next().charAt(0);
            in.nextLine();

            System.out.print("Name: ");
            String name = in.nextLine();

            System.out.print("Price: ");
            double price = in.nextDouble();

            if (productType == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(in.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                products.add(new UsedProduct(name, price, manufactureDate));
            } else if (productType == 'i') {
                System.out.print("Customs fee: ");
                double customFee = in.nextDouble();
                products.add(new ImportedProduct(name, price, customFee));

            } else {
                products.add(new Product(name, price));
            }
        }

        System.out.println("\n PRICE TAGS:");
        for (Product prod : products) {
            System.out.println(prod.priceTag());
        }

        in.close();
    }
}
