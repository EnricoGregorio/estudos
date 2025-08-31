import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int valor = in.nextInt();

        if (valor >= 0) {
            System.out.println("Não negativo");
        } else {
            System.out.println("Negativo");
        }
        
        in.close();
    }
}
