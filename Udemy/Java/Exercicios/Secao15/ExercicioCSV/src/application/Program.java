package application;

import model.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Cria uma lista de produtos
        List<Product> products = new ArrayList<>();

        // Lemos o caminho do arquivo .csv.
        System.out.print("Enter a file .csv path: ");
        String strPath = in.nextLine();

        // Pegamos apenas o diretório do arquivo .csv e criamos uma pasta
        // chamada "out" no mesmo diretório do arquivo, para facilitar.
        File path = new File(strPath);
        String strDir = path.getParent() + "/out";
        boolean createdOutFolder = new File(strDir).mkdir();

        // Preparamos uma "String" para ser o caminho para o novo arquivo
        // que criaremos posteriormente.
        String strDirSummary = strDir + "/summary.csv";

        // Bloco para ler cada linha do arquivo .csv.
        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String productLine = br.readLine();
            while (productLine != null) {
                // Abaixo, iremos pegar cada linha do arquivo como uma "String" e
                // separar os itens para criarmos um Product.
                String[] fields = productLine.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);
                products.add(new Product(name, price, quantity));
                // Abaixo, seguimos para a próxima linha.
                productLine = br.readLine();
            }
            // Bloco para criarmos o novo arquivo.
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(strDirSummary))) {
                for (Product item : products) {
                    // Com base em cada produto "Item" em "products", iremos escrever
                    // em nosso arquivo.
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error while writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        in.close();
    }
}
