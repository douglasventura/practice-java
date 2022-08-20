package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class App {
    
    public static void main(String[] args) {
        
        String path = "./../in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path)); 
        Scanner sc = new Scanner(System.in)) {
            
            List<Employee> list = new ArrayList<Employee>();
            
            String line = br.readLine();
            
            while (line != null) {
                String[] fields = line.split(",");
                
                String name = fields[0];
                String email = fields[1];
                Double salary = Double.parseDouble(fields[2]);
                
                list.add(new Employee(name, email, salary));

                line = br.readLine();
            }

            System.out.println("Enter full file path: " + path + " (Referential path)");

            System.out.print("Enter salary: ");
            double salaryComparator = sc.nextDouble();

            System.out.println("Email of people whose salary is more than " + salaryComparator + ":");

            // email list of people who earn more than input salary (salaryComparator)
            List<String> emails = list.stream()
            .filter(employee -> employee.getSalary() > salaryComparator)
            .map(employee -> employee.getEmail())
            .sorted()
            .toList();
            
            emails.forEach(System.out::println);
            
            // sum of salary of the employees whose name starts with 'M'
            double sumOfSalaryM = list.stream()
                .filter(employee -> employee.getName().charAt(0) == 'M')
                .map(employee -> employee.getSalary())
                .reduce(0.0, (accumulator, salary) -> accumulator + salary);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumOfSalaryM));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
