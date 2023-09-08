package kz.zhelezyaka.solid.ocp.withoutOCP;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("--This example without OCP principal--");
        List<Student> enrolledStudents = enrollStudents();

        System.out.println("Results: ");
        for (Student student : enrolledStudents) {
            System.out.println(student);
        }


        System.out.println("Distinctions: ");
        DistinctionDecider distinctionDecider = new DistinctionDecider();
        for (Student student : enrolledStudents) {
            distinctionDecider.evaluateDistinction(student);
        }
    }

    private static List<Student> enrollStudents() {
        Student vladimir = new Student("Vladimir", "R1", 82.1, "Computer Science");
        Student svetlana = new Student("Svetlana", "R2", 62, "Physics");
        Student anna = new Student("Anna", "R3", 89, "History");
        Student nikolay = new Student("Nikolay", "R4", 56.9, "English");

        List<Student> students = new ArrayList<>();
        students.add(vladimir);
        students.add(svetlana);
        students.add(anna);
        students.add(nikolay);
        return students;
    }
}
