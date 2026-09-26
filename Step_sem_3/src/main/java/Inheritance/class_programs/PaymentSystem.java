package Inheritance.class_programs;

import java.util.Scanner;

abstract class PaymentMethod {
    abstract double calculateFinalAmount(double amount);
}

class CardPayment extends PaymentMethod {
    double calculateFinalAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    double calculateFinalAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    double calculateFinalAmount(double amount) {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            PaymentMethod method;

            if (type.equals("CARD")) {
                method = new CardPayment();
            } else if (type.equals("WALLET")) {
                method = new WalletPayment();
            } else {
                method = new BankTransferPayment();
            }

            double adjustedAmount = method.calculateFinalAmount(amount);
            grandTotal += adjustedAmount;
            System.out.printf("%s: %.2f%n", type, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}

