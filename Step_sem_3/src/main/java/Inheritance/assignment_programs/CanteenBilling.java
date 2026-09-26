package Inheritance.assignment_programs;

import java.util.Scanner;

abstract class Customer {
    abstract double calculateFinalAmount(double amount);
}

class StudentCustomer extends Customer {
    double calculateFinalAmount(double amount) {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    double calculateFinalAmount(double amount) {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    double calculateFinalAmount(double amount) {
        return amount + 10.0;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new StudentCustomer();
            } else if (type.equals("STAFF")) {
                customer = new StaffCustomer();
            } else {
                customer = new GuestCustomer();
            }

            double finalAmount = customer.calculateFinalAmount(amount);
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
