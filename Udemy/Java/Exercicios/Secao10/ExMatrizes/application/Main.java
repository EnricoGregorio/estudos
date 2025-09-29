package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] matriz = new int[m][n];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = in.nextInt();
            }
        }

        int x = in.nextInt();

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == x) {
                    System.out.printf("%nPosition %d,%d:%n", i, j);

                    if (j > 0) {
                        System.out.println("Left: " + matriz[i][j - 1]);
                    }

                    if (i > 0) {
                        System.out.println("Up: " + matriz[i-1][j]);
                    }

                    if (j < matriz[i].length - 1) {
                        System.out.println("Right: " + matriz[i][j + 1]);
                    }

                    if (i < matriz.length - 1) {
                        System.out.println("Down: " + matriz[i + 1][j]);
                    }
                }
            }
        }

        System.out.println(matriz[10][1]);

        in.close();
    }
}
