package Encapsulation.class_programs;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (studentName == null || studentName.trim().isEmpty() || isPresent(studentName)) {
            return;
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = studentName;
            presentCount++;
        }
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return presentCount;
    }
}

