import java.util.Locale;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        float salario = in.nextFloat();
        float valorIR;

        if (salario <= 2000.0) {
            valorIR = 0.0f;
        } else if (salario <= 3000.0) {
            valorIR = (salario - 2000.0f) * 0.08f;
        } else if (salario <= 4500.0) {
            valorIR = (salario - 3000.0f) * 0.18f + 1000.0f * 0.08f;
        } else {
            valorIR = (salario - 4500.0f) * 0.28f + 1500.0f * 0.18f + 1000.0f * 0.08f;
        }

        if (valorIR == 0.0) {
            System.out.println("Isento");
        } else {
            System.out.printf("R$ %.2f%n", valorIR);
        }

        in.close();
    }
}
