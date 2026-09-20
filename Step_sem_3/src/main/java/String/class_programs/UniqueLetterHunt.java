package String.class_programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueLetterHunt {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void displayResult(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        displayResult("swiss");
        displayResult("aabbcc");
    }
}

