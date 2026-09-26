package Inheritance.assignment_programs;

import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateParkingCharge(int hours);
}

class BikeVehicle extends Vehicle {
    double calculateParkingCharge(int hours) {
        return hours * 10.0;
    }
}

class CarVehicle extends Vehicle {
    double calculateParkingCharge(int hours) {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class TruckVehicle extends Vehicle {
    double calculateParkingCharge(int hours) {
        double charge = hours * 50.0;
        return Math.max(100.0, charge);
    }
}

public class ParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new BikeVehicle();
            } else if (type.equals("CAR")) {
                vehicle = new CarVehicle();
            } else {
                vehicle = new TruckVehicle();
            }

            double charge = vehicle.calculateParkingCharge(hours);
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}

