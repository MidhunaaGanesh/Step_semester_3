package Inheritance.class_programs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    abstract int getBorrowingPeriod();
}

class BookItem extends LibraryItem {
    int getBorrowingPeriod() { return 14; }
}

class DvdItem extends LibraryItem {
    int getBorrowingPeriod() { return 7; }
}

class MagazineItem extends LibraryItem {
    int getBorrowingPeriod() { return 3; }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            LibraryItem item;
            if (type.equals("BOOK")) {
                item = new BookItem();
            } else if (type.equals("DVD")) {
                item = new DvdItem();
            } else {
                item = new MagazineItem();
            }

            LocalDate dueDate = currentDate.plusDays(item.getBorrowingPeriod());
            System.out.println(title + ": " + dueDate.format(formatter));
        }
    }
}

