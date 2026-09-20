package OOP.assignment_programs;

public class AtmKiosk {

    public static void atmPinRetry(String correctPin, String[] attempts) {
        if (correctPin == null || attempts == null) {
            return;
        }

        int i = 0;
        boolean success = false;
        int maxAttempts = Math.min(3, attempts.length);

        while (i < maxAttempts && !success) {
            if (attempts[i] != null && attempts[i].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            i++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        atmPinRetry("4821", new String[]{"1111", "4821"});
        atmPinRetry("4821", new String[]{"1111", "2222", "3333"});
    }
}

