import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int valor = in.nextInt();
        String ePar = (valor % 2 == 0) ? "PAR" : "IMPAR";
        System.out.println(ePar);

        in.close();
    }
}
