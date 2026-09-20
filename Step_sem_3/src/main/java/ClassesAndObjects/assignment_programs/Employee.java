package ClassesAndObjects.assignment_programs;

class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CorporateInformationManagement {
    public static void main(String[] args) {
        new Employee("Amit", 45000);
        new Employee("Bhavna", 55000);
        new Employee("Chirag", 60000);

        Employee.printCompanyInfo();
    }
}

