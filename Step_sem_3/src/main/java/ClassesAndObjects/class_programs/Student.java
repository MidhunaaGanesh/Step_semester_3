package ClassesAndObjects.class_programs;

class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentInformationManagement {
    public static void main(String[] args) {
        new Student("Rahul", 85);
        new Student("Sneha", 90);

        Student.printCollegeInfo();
    }
}

