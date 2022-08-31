package application;

import java.util.Scanner;

import entities.BrazilInterestService;
import entities.InterestService;

public class App {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            
            System.out.print("Months: ");
            int months = sc.nextInt();
    
            InterestService brazilInterestService = new BrazilInterestService(2.0);
            InterestService usaInterestService = new BrazilInterestService(1.0);
            
            System.out.println("Payment after " + months + " months: ");
            System.out.println(" - Brazil: " + String.format("%.2f", brazilInterestService.payment(amount, months)));
            System.out.println(" - USA: " + String.format("%.2f", usaInterestService.payment(amount, months)));
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
