package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {}

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getcheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Long duration() {
        Duration duration = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
        return duration.toDays();
    }

    // SOLUÇÃO RUIM
//    public String updateDates(LocalDate checkIn, LocalDate checkOut) {
//        LocalDate now = LocalDate.now();
//        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
//            return "Reservation dates for update must be future.";
//        }
//        if (!checkOut.isAfter(checkIn)) {
//            return "Check-out date must be after Check-in date.";
//        }
//        this.checkIn = checkIn;
//        this.checkOut = checkOut;
//        return null;
//    }

    // SOLUÇÃO BOA
    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Reservation dates must be future dates.");
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation: Room "
                + getRoomNumber()
                + ", check-in: "
                + getcheckIn().format(formatter)
                + ", check-out: "
                + getCheckOut().format(formatter)
                + ", "
                + duration()
                + " nights";
    }
}