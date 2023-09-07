package kz.zhelezyaka.solid.srp.badPractice;

public class Client {
    public static void main(String[] args) {
        System.out.println("--This example without SRP principal.--");

        Employee vladimir = new Employee("Vladimir", "Glinskikh", 5);
        showEmployeeDetail(vladimir);

        System.out.println("---------------------");

        Employee svetlana = new Employee("Svetlana", "Svetina", 3);
        showEmployeeDetail(svetlana);
    }

    private static void showEmployeeDetail(Employee employee) {
        employee.displayEmployeeDetail();
        System.out.println("Employee ID: " +
                employee.generateEmployeeId(employee.firstName));
        System.out.println("Employee is a " +
                employee.checkSeniority(employee.experienceInYear) +
                " employee.");
    }
}