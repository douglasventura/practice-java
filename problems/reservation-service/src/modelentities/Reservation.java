package modelentities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import modelexceptions.DomainException;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        
        if (checkin.isAfter(checkout)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff = ChronoUnit.DAYS.between(checkin, checkout);
        return diff;
    }

    public void updateDates(LocalDate checkin, LocalDate checkout) {
        LocalDate now = LocalDate.now();

        if (checkin.isAfter(checkout) || now.isAfter(checkin)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (checkin.isAfter(checkout)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        
        info.append("Reservation: Room ")
        .append(roomNumber)
        .append(", check-in: ")
        .append(getCheckin().format(fmt))
        .append(", check-out: ")
        .append(getCheckout().format(fmt))
        .append(", ")
        .append(duration())
        .append(" nigths");

        return info.toString();
    }    
}
