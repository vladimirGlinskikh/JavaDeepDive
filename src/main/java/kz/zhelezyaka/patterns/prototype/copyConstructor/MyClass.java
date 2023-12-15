package kz.zhelezyaka.patterns.prototype.copyConstructor;

public class MyClass {
    private String name;
    private int age;

    // Обычный конструктор
    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Конструктор копирования
    public MyClass(MyClass original) {
        this.name = original.name;
        this.age = original.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        MyClass original = new MyClass("Aston", 10);

        // Используем конструктор копирования для создания копии
        MyClass copy = new MyClass(original);

        original.display();
        copy.display();
    }
}
