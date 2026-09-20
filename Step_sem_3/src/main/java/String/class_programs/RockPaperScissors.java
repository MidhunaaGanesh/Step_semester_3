package String.class_programs;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        int totalRounds = 5;
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < totalRounds; i++) {
            int compIndex = random.nextInt(3);
            String compMove = choices[compIndex];
            computerMoves[i] = compMove;

            String pMove = choices[random.nextInt(3)];
            playerMoves[i] = pMove;

            String result = playRound(pMove, compMove);
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-5d | %-11s | %-13s | %s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.println("\nFinal Summary");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}

