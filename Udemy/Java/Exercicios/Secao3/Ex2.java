import java.util.Locale;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        double raio = input.nextDouble();
        double area = Math.PI * Math.pow(raio, 2);
        System.out.printf("A = %.4f%n", area);
        input.close();
    }
}
