package OOP.class_programs;

import java.util.Scanner;

public class GcdSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        int origNumber1 = number1;
        int origNumber2 = number2;

        while (number2 != 0) {
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }

        System.out.println("The GCD of " + origNumber1 + " and " + origNumber2 + " is " + number1);
    }
}

