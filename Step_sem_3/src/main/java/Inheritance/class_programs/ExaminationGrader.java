package Inheritance.class_programs;

import java.util.Scanner;

abstract class ExamQuestion {
    String correctAnswer;
    String studentAnswer;
    double points;

    public ExamQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double gradeQuestion();
}

class McqQuestion extends ExamQuestion {
    public McqQuestion(String c, String s, double p) { super(c, s, p); }
    double gradeQuestion() { return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0; }
}

class TfQuestion extends ExamQuestion {
    public TfQuestion(String c, String s, double p) { super(c, s, p); }
    double gradeQuestion() { return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0; }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String c, String s, double p) { super(c, s, p); }
    double gradeQuestion() {
        String[] keywords = correctAnswer.split(",\\s*");
        int matchCount = 0;
        String lowerStudent = studentAnswer.toLowerCase();

        for (String word : keywords) {
            if (lowerStudent.contains(word.toLowerCase().trim())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.Scanner.class.getResourceAsStream("/dev/stdin") != null ? new Scanner(System.in) : null);
        if (scanner == null) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        double overallScore = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\" ");

            String firstPart = tokens[0];
            int firstSpace = firstPart.indexOf(' ');
            String type = firstPart.substring(0, firstSpace);

            String correctAns = tokens[2].replace("\"", "");
            String studentAns = tokens[3].replace("\"", "");
            double points = Double.parseDouble(tokens[4].trim());

            ExamQuestion question;
            if (type.equals("MCQ")) {
                question = new McqQuestion(correctAns, studentAns, points);
            } else if (type.equals("TF")) {
                question = new TfQuestion(correctAns, studentAns, points);
            } else {
                question = new EssayQuestion(correctAns, studentAns, points);
            }

            double score = question.gradeQuestion();
            overallScore += score;
            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", overallScore);
    }
}

