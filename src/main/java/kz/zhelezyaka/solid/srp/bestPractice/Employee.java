package kz.zhelezyaka.solid.srp.bestPractice;

public class Employee {
    public String firstName, lastName, employeeId;
    public double experienceInYear;

    public Employee(String firstName,
                    String lastName,
                    double experienceInYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYear = experienceInYear;
    }

    public void displayEmployeeDetail() {
        System.out.println("Employee name: " + firstName + ", " + lastName);
        System.out.println("Employee has : "
                + experienceInYear + " years of experience.");
    }
}
