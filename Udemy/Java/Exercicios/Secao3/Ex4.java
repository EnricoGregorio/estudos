import java.util.Locale;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        Scanner input = new Scanner(System.in);
        
        int numFuncionario = input.nextInt();
        int hTrabalhadas = input.nextInt();
        double valPorHora = input.nextDouble();
        double salario = hTrabalhadas * valPorHora;

        System.out.println("Number = " + numFuncionario);
        System.out.printf("Salary = U$%.2f%n", salario);

        input.close();
    }
}
