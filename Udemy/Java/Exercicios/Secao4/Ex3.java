import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();

        String saoMultiplos = (a % b == 0 || b % a == 0) ? "São Múltiplos" : "Não são múltiplos"; 
        System.out.println(saoMultiplos);
        
        in.close();
    }
}
