package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class App {

    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();
        String path = "./txt-file/employees.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeeLine = br.readLine();
            
            while (employeeLine != null) {
                String[] datas = employeeLine.split(",");
                employees.add(new Employee(datas[0], Double.parseDouble(datas[1])));
                employeeLine = br.readLine();
            }

            Collections.sort(employees);

            for (Employee employee : employees) {
                System.out.println("Name: " + employee.getName() + " - Salary: " + employee.getSalary());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}