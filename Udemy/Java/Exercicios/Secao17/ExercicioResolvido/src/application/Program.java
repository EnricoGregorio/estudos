package application;

import model.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = in.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(" ");
                String username = fields[0];
                Instant moment = Instant.parse(fields[1]);

                set.add(new LogEntry(username, moment));

                line = br.readLine();
            }

            System.out.println("Total users:  " + set.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        in.close();
    }
}
