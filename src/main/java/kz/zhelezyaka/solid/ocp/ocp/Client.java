package kz.zhelezyaka.solid.ocp.ocp;

import java.util.ArrayList;
import java.util.List;

class Client {

	public static void main(String[] args) {
		System.out.println("--This example use OCP principal--");
		List<Student> scienceStudents = enrollScienceStudents();
		List<Student> artsStudents = enrollArtsStudents();

		System.out.println("Results: ");

		for (Student student : scienceStudents) {
			System.out.println(student);
		}
		for (Student student : artsStudents) {
			System.out.println(student);
		}

		DistinctionDecider scienceDistinctionDecider = new ScienceDistinctionDecider();
		DistinctionDecider artsDistinctionDecider = new ArtsDistinctionDecider();
		System.out.println("Distinctions: ");
		for (Student student : scienceStudents) {
			scienceDistinctionDecider.evaluateDistinction(student);
		}
		for (Student student : artsStudents) {
			artsDistinctionDecider.evaluateDistinction(student);
		}

	}

	private static List<Student> enrollScienceStudents() {
		Student vladimir = new ScienceStudent("Vladimir", "R1", 82.1, "Computer Science");
		Student svetlana = new ScienceStudent("Svetlana", "R2", 62, "Physics");
		List<Student> scienceStudents = new ArrayList<Student>();
		scienceStudents.add(vladimir);
		scienceStudents.add(svetlana);
		return scienceStudents;
	}

	private static List<Student> enrollArtsStudents() {
		Student anna = new ArtsStudent("Anna", "R3", 89, "History");
		Student nikolay = new ArtsStudent("Nikolay", "R4", 56.9, "English");
		List<Student> artsStudents = new ArrayList<Student>();
		artsStudents.add(anna);
		artsStudents.add(nikolay);
		return artsStudents;
	}

}