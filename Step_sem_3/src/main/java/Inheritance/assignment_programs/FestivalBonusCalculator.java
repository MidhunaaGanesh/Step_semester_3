package Inheritance.assignment_programs;

import java.util.Scanner;

abstract class CbEmployee {
    String name;
    double monthlySalary;

    public CbEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends CbEmployee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends CbEmployee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends CbEmployee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            CbEmployee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTimeEmployee(name, salary);
            } else {
                employee = new InternEmployee(name, salary);
            }

            double bonus = employee.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }
}

