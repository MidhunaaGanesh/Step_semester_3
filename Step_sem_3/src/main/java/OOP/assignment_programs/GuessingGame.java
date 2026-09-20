package OOP.assignment_programs;

public class GuessingGame {

    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        if (guesses == null) {
            return;
        }

        int attempts = 0;
        boolean guessedCorrectly = false;
        int totalGuessesAvailable = Math.min(maxTries, guesses.length);

        while (attempts < totalGuessesAvailable && !guessedCorrectly) {
            int currentGuess = guesses[attempts];

            if (currentGuess == secretNumber) {
                System.out.println("Correct! You guessed it");
                guessedCorrectly = true;
                break;
            } else if (currentGuess > secretNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            }
            attempts++;
        }

        if (!guessedCorrectly) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        guessTheNumber(42, 4, new int[]{20, 60, 42});
        guessTheNumber(42, 2, new int[]{10, 15});
    }
}

