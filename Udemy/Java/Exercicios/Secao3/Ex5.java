import java.util.Locale;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        int codPeca1 = input.nextInt();
        int qtdPecas1 = input.nextInt();
        double valCadaPeca1 = input.nextDouble();
        
        int codPeca2 = input.nextInt();
        int qtdPecas2 = input.nextInt();
        double valCadaPeca2 = input.nextDouble();

        double valTotal = qtdPecas1 * valCadaPeca1 + qtdPecas2 * valCadaPeca2;

        System.out.printf("Total a pagar: R$%.2f%n", valTotal);
        input.close();
    }
}
