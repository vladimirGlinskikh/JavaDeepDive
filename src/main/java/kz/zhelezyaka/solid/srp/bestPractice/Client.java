package kz.zhelezyaka.solid.srp.bestPractice;

public class Client {
    public static void main(String[] args) {
        System.out.println("--This example with SRP principal--");

        Employee vladimir = new Employee("Vladimir", "Glinskikh", 5);
        showEmployeeDetail(vladimir);
        System.out.println("--------------------------------");

        Employee svetlana = new Employee("Svetlana", "Svetina", 3);
        showEmployeeDetail(svetlana);
    }

    private static void showEmployeeDetail(Employee employee) {
        employee.displayEmployeeDetail();

        EmployeeIDGenerator idGenerator = new EmployeeIDGenerator();

        String employeeID = idGenerator.generateEmployeeId(employee.firstName);
        System.out.println("Employee ID: " + employeeID);

        SeniorityChecker seniorityChecker = new SeniorityChecker();
        System.out.println("Employee is a "
                + seniorityChecker.checkSeniority(employee.experienceInYear) +
                " employee.");
    }
}
