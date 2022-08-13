package application;

import java.util.Scanner;

import services.PrintService;

public class App {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.print("How many values: ");
            int values = sc.nextInt();

            PrintService<Integer> ps = new PrintService<>();

            for (int i = 0; i < values; i++) {
                Integer value = sc.nextInt();
                ps.addValue(value);
            }

            ps.print();
            System.out.println("First: " + ps.first());
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
