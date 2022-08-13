package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationService;

public class App {
  
    public static void main(String[] args) {
        
        List<Product> list = new ArrayList<>();
        String path = "../files/in.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null) {
                String[] data = line.split(",");
                list.add(new Product(data[0], Double.parseDouble(data[1])));
                line = reader.readLine();
            }

            System.out.println("Most expensive:");
            System.out.println(CalculationService.max(list));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
