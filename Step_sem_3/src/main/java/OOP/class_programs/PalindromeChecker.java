package OOP.class_programs;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int number = scanner.nextInt();
        int origNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        boolean isPalindrome = (reversedNumber == origNumber);
        System.out.println("Is the number " + origNumber + " a Palindrome? " + isPalindrome);
    }
}

