package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int quantity;

        Product product = new Product();
        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        product.name = in.nextLine();
        System.out.print("Price: ");
        product.price = in.nextDouble();
        System.out.print("Quantity in stock: ");
        product.quantity = in.nextInt();

        System.out.println("Product data: " + product);
        System.out.print("\nEnter the number of products to be added in stock: ");
        quantity = in.nextInt();
        product.addProducts(quantity);
        System.out.println("\nUpdated data: " + product);
        System.out.print("\nEnter the number of products to be removed from stock: ");
        quantity = in.nextInt();
        product.removeProducts(quantity);
        System.out.println("\nUpdated data: " + product);
        in.close();
    }
}
