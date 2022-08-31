package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {

    public static void main(String[] args) {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            
            sc.nextLine();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);
            
            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);
    
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);
            
            System.out.println();
            System.out.println("Enter date to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkout = LocalDate.parse(sc.nextLine(), fmt);
            
            reservation.updateDates(checkin, checkout);
            System.out.println(reservation);   
            
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
        
        sc.close();
    }
}