package kz.zhelezyaka.solid.srp.badPractice;

import java.util.Random;

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

    public String checkSeniority(double experienceInYear) {
        return experienceInYear >= 5 ? "senior" : "junior";
    }

    public String generateEmployeeId(String employeeFirstName) {
        int random = new Random().nextInt(1000);
        employeeId = employeeFirstName.substring(0, 1) + random;
        return employeeId;
    }
}
