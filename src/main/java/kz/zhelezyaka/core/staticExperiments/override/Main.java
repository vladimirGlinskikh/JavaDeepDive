package kz.zhelezyaka.core.staticExperiments.override;

class Parent {
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent.staticMethod();
        Child.staticMethod(); 
    }
}
