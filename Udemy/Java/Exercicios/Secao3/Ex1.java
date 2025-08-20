import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int valor1 = input.nextInt();
        int valor2 = input.nextInt();
        int soma = valor1 + valor2;
        System.out.println("Soma = " + soma);
        input.close();
    }
}
