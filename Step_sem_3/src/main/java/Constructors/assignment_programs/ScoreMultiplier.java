package Constructors.assignment_programs;

import java.util.Arrays;

public class ScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null || captainIndex < 0 || captainIndex >= playerScores.length ||
                viceCaptainIndex < 0 || viceCaptainIndex >= playerScores.length) {
            return;
        }
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}

