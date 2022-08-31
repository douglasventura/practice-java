package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class App {

    public static void main(String[] args) {
        
        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200.00);
        System.out.println(acc1.getBalance());
        
        // Upcasting: Account instantiated with SavingsAccount
        Account acc2 = new SavingsAccount(1002, "Bob", 1000.0, 0.01);
        acc2.withdraw(200.00);
        System.out.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(1003, "Anna", 1000.0, 500.0);
        acc3.withdraw(200.00);
        System.out.println(acc3.getBalance());
    }
}