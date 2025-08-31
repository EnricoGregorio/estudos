package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        Student student = new Student();

        student.name = in.nextLine();
        student.grade1 = in.nextDouble();
        student.grade2 = in.nextDouble();
        student.grade3 = in.nextDouble();

        System.out.printf("Final grade = %.2f%n", student.finalGrade());

        if (student.finalGrade() < 60) {
            System.out.println("Failed");
            System.out.printf("Missing %.2f points%n", student.missingPoints());
        } else {
            System.out.println("Pass");
        }

        in.close();
    }
}
