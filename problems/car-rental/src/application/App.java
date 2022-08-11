package application;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import modelentities.CarRental;
import modelentities.Vehicle;
// import modelservices.BrazilTaxService;
import modelservices.RentalService;
import modelservices.UsaTaxService;

public class App {

    public static void main(String[] args) {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        
        try (Scanner sc = new Scanner(System.in)) {
            String carModel = sc.nextLine();
            
            System.out.print("Pickup (DD/MM/YYYY HH:MM): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
            
            System.out.print("Pickup (DD/MM/YYYY HH:MM): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
            
            CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
            
            System.out.print("Enter price per hour: ");
            double pricePerHour = sc.nextDouble();
            
            System.out.print("Enter price per day: ");
            double pricePerDay = sc.nextDouble();
    
            RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new UsaTaxService());
            rentalService.processInvoice(carRental);
            
            System.out.println("INVOICE:");
            System.out.printf("Basic payment: %.2f%n", carRental.getInvoice().getBasicPayment());
            System.out.printf("Tax: %.2f%n", carRental.getInvoice().getTax());
            System.out.printf("Total payment: %.2f%n", carRental.getInvoice().getTotalPayment());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        
    }
}