import java.util.Locale;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double triangulo = a * c / 2;
        double circulo = Math.PI * Math.pow(c, 2);
        double trapezio = (a + b) * c / 2;
        double quadrado = b * b;
        double retangulo = a * b;

        System.err.printf("Triângulo: %.3f%nCírculo: %.3f%nTrapézio: %.3f%nQuadrado: %.3f%nRetângulo: %.3f%n", triangulo, circulo, trapezio, quadrado, retangulo);
        input.close();
    }
}
