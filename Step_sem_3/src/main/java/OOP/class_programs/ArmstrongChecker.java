package OOP.class_programs;

import java.util.Scanner;

public class ArmstrongChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int number = scanner.nextInt();
        int origNumber = number;
        int sum = 0;

        int temp = number;
        int digitsCount = 0;
        while (temp > 0) {
            digitsCount++;
            temp /= 10;
        }

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digitsCount);
            number = number / 10;
        }

        boolean isArmstrong = (sum == origNumber);
        System.out.println("Is the number " + origNumber + " an Armstrong number? " + isArmstrong);
    }
}

