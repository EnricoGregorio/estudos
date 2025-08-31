import java.util.Locale;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        double preco = 0;
        int codItem = in.nextInt();
        int qtdItem = in.nextInt();

        switch (codItem) {
            case 1:
                preco = qtdItem * 4;
                break;
            case 2:
                preco = qtdItem * 4.5;
                break;
            case 3:
                preco = qtdItem * 5;
                break;
            case 4:
                preco = qtdItem * 2;
                break;
            case 5:
                preco = qtdItem * 1.5;
            default:
                break;
        }

        System.out.printf("Total: R$ %.2f%n", preco);

        in.close();
    }
}
