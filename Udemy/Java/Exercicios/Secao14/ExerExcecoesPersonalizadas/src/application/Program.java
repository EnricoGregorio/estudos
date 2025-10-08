package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // SOLUÇÃO MUITO RUIM/RUIM
//        System.out.print("Room number: ");
//        int roomNumber = in.nextInt();
//
//        System.out.print("Check-in date (DD/MM/YYYY): ");
//        LocalDate checkIn = LocalDate.parse(in.next(), Reservation.formatter);
//
//        System.out.print("Check-out date (DD/MM/YYYY): ");
//        LocalDate checkOut = LocalDate.parse(in.next(), Reservation.formatter);

        // SOLUÇÃO MUITO RUIM
//        if (!checkOut.isAfter(checkIn)) {
//            System.out.println("Error in reservation: Check-out date must be after Check-in date.");
//        } else {
//            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
//            System.out.println(reservation + "\n");
//
//            System.out.println("Enter data to update the reservation:");
//            System.out.print("Check-in date (DD/MM/YYYY): ");
//            checkIn = LocalDate.parse(in.next(), Reservation.formatter);
//            System.out.print("Check-out date (DD/MM/YYYY): ");
//            checkOut = LocalDate.parse(in.next(), Reservation.formatter);
//
//            LocalDate now = LocalDate.now();
//
//            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
//                System.out.println("Error in reservation: Reservation dates for update must be future.");
//            } else if (!checkOut.isAfter(checkIn)) {
//                System.out.println("Error in reservation: Check-out date must be after Check-in date.");
//            } else {
//                reservation.updateDates(checkIn, checkOut);
//                System.out.println(reservation);
//            }
//        }

        // SOLUÇÃO RUIM
//        if (!checkOut.isAfter(checkIn)) {
//            System.out.println("Error in reservation: Check-out date must be after Check-in date.");
//        } else {
//            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
//            System.out.println(reservation + "\n");
//            System.out.println("Enter data to update the reservation:");
//            System.out.print("Check-in date (DD/MM/YYYY): ");
//            checkIn = LocalDate.parse(in.next(), Reservation.formatter);
//            System.out.print("Check-out date (DD/MM/YYYY): ");
//            checkOut = LocalDate.parse(in.next(), Reservation.formatter);
//
//            String error = reservation.updateDates(checkIn, checkOut);
//            if (error != null) {
//                System.out.println("Error in reservation: " + error);
//            } else {
//                System.out.println(reservation);
//            }
//        }

        // SOLUÇÃO BOA
        try {
            System.out.print("Room number: ");
            int roomNumber = in.nextInt();

            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(in.next(), Reservation.formatter);

            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(in.next(), Reservation.formatter);
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation + "\n");

            System.out.println("Enter data to update the reservation:");

            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(in.next(), Reservation.formatter);

            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(in.next(), Reservation.formatter);

            reservation.updateDates(checkIn, checkOut);
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
        in.close();
    }
}