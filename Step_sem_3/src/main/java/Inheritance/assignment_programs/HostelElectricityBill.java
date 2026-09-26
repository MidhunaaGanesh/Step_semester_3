package Inheritance.assignment_programs;

import java.util.Scanner;

abstract class HostelRoom {
    abstract double calculateBill(int units);
}

class SingleRoom extends HostelRoom {
    double calculateBill(int units) {
        return units * 8.0;
    }
}

class SharedRoom extends HostelRoom {
    private final int occupants;

    public SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    double calculateBill(int units) {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends HostelRoom {
    double calculateBill(int units) {
        return (units * 10.0) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            HostelRoom room;

            if (type.equals("SINGLE")) {
                room = new SingleRoom();
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                room = new SharedRoom(occupants);
            } else {
                room = new AcRoom();
            }

            double billAmount = room.calculateBill(units);
            grandTotal += billAmount;
            System.out.printf("%s: %.2f%n", type, billAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}

