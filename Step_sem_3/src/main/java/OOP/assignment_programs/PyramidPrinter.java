package OOP.assignment_programs;

public class PyramidPrinter {

    public static void printNumberPyramid(int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printNumberPyramid(4);
    }
}

