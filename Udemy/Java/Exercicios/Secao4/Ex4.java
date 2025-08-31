import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int hInicial = in.nextInt();
        int hFinal = in.nextInt();

        int duracao;

        if (hFinal > hInicial) {
            duracao = hFinal - hInicial;
        } else {
            duracao = 24 - hInicial + hFinal;
        }

        System.out.printf("O jogo durou %d hora(s)%n", duracao);
        in.close();
    }
}
