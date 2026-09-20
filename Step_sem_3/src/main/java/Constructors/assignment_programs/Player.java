package Constructors.assignment_programs;

import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftEngine {

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        if (isDraftable(matchesPlayed)) {
            return true;
        }
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        Player[] tempDraftable = new Player[players.length];
        int count = 0;

        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                tempDraftable[count++] = p;
            }
        }

        Player[] draftable = Arrays.copyOf(tempDraftable, count);
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] batch = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(batch));
    }
}

