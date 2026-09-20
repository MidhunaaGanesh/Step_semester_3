package String_Functions.assignment_programs;

public class LibraryValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("] ");
        formatted.append("YEAR: ").append(year).append(" | CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String input1 = " pen2026004251 ";
        String normalized1 = normalizeCode(input1);
        System.out.println(validateAndFormat(normalized1));

        String input2 = "12N2026004251";
        String normalized2 = normalizeCode(input2);
        System.out.println(validateAndFormat(normalized2));
    }
}

