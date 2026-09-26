package Inheritance.class_programs;

import java.util.Scanner;

abstract class TransportJourney {
    double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2.0 * distance;
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 5.0 + (1.5 * distance);
    }
}

class MetroJourney extends TransportJourney {
    double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (3.0 * distance) * peakHourFactor;
    }
}

public class PublicTransportCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotalFare = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            TransportJourney journey;

            if (type.equals("BUS")) {
                journey = new BusJourney(distance);
            } else if (type.equals("TRAIN")) {
                journey = new TrainJourney(distance);
            } else {
                double peakHourFactor = scanner.nextDouble();
                journey = new MetroJourney(distance, peakHourFactor);
            }

            double fare = journey.calculateFare();
            grandTotalFare += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", grandTotalFare);
    }
}
