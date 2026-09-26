package Inheritance.class_programs;

import java.util.Scanner;

abstract class DeliveryRequest {
    double weight;
    double distance;

    public DeliveryRequest(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    double calculateFee() { return 5 + (0.50 * weight) + (0.10 * distance); }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    double calculateFee() { return 15 + (1.00 * weight) + (0.20 * distance); }
}

class InternationalDelivery extends DeliveryRequest {
    double customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    double calculateFee() { return 25 + (2.00 * weight) + (0.50 * distance) + customsFee; }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotalFee = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            DeliveryRequest request;

            if (type.equals("STANDARD")) {
                request = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                request = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = scanner.nextDouble();
                request = new InternationalDelivery(weight, distance, customsFee);
            }

            double fee = request.calculateFee();
            grandTotalFee += fee;
            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", grandTotalFee);
    }
}

