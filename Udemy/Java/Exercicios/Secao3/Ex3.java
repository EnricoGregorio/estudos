import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int diferenca = a * b - c * d;
        System.out.println("Diferença = " + diferenca);
        input.close();
    }
}
