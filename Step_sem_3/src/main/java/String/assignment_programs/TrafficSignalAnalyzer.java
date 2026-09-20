package String.assignment_programs;

public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxCount = 1;

        char currentColor = signalLog.charAt(0);
        int currentCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char nextColor = signalLog.charAt(i);

            if (nextColor == currentColor) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxColor = currentColor;
                }
                currentColor = nextColor;
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxColor = currentColor;
        }

        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxCount + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}

