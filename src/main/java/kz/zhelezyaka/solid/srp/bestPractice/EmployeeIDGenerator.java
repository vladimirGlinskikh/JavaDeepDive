package kz.zhelezyaka.solid.srp.bestPractice;

import java.util.Random;

public class EmployeeIDGenerator {
    String employeeId;

    public String generateEmployeeId(String employeeFirstName) {
        int random = new Random().nextInt(1000);
        employeeId = employeeFirstName.substring(0, 1) + random;
        return employeeId;
    }
}
