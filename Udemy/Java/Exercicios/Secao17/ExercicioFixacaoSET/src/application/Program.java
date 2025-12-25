package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    static void main() {
        Scanner in = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        System.out.print("How many students for course A? ");
        int nStudents = in.nextInt();
        addStudents(a, nStudents);

        System.out.print("How many students for course B? ");
        nStudents = in.nextInt();
        addStudents(b, nStudents);

        System.out.print("How many students for course C? ");
        nStudents = in.nextInt();
        addStudents(c, nStudents);

        Set<Integer> total = new HashSet<>(a);
        total.addAll(b);
        total.addAll(c);

        System.out.println("Total students: " + total.size());

        in.close();
    }

    public static void addStudents(Set<Integer> course, int nStudents) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < nStudents; i++) {
            int id = in.nextInt();
            course.add(id);
        }
    }
}
