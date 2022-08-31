package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.PayPalPaymentService;
import model.services.ProcessPaymentService;

public class App {
    
    public static void main(String[] args) {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter contract data");
            
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

            System.out.print("Contract value: ");
            double totalValue = sc.nextDouble();
            
            System.out.print("Enter number of installments: ");
            int numberOfInstallments = sc.nextInt();

            Contract contract = new Contract(number, date, totalValue);
            ProcessPaymentService processPaymentService = new ProcessPaymentService(new PayPalPaymentService());
            processPaymentService.processInstallments(contract, numberOfInstallments);
            
            System.out.println("Installments:");
            for (Installment installment : contract.getInstallment()) {
                System.out.println(installment.toString());
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
