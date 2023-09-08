package kz.zhelezyaka.solid.ocp.ocp;

abstract class Student {
    String name;
    String regNumber;
    double score;
    String department;

    public Student(String name,
                   String regNumber,
                   double score) {
        this.name = name;
        this.regNumber = regNumber;
        this.score = score;
    }

    public String toString() {
        return ("Name: " + name +
                "\nReg Number: " + regNumber +
                "\nMarks:" + score +
                "\nDept:" + department +
                "\n");
    }
}