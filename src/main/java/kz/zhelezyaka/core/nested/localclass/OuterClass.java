package kz.zhelezyaka.core.nested.localclass;

import static java.lang.System.*;

public class OuterClass {
    private final int outerField;

    public OuterClass() {
        outerField = 10;
    }

    public void localClassExample() {
        final int localVar = 5; // Локальная переменная, которую мы хотим использовать в локальном классе

        // Локальный класс
        class LocalClass {
            void display() {
                out.println("Outer field: " + outerField);
                out.println("Local variable: " + localVar);
            }
        }

        // Создание экземпляра локального класса и вызов метода
        LocalClass localObj = new LocalClass();
        localObj.display();
    }

    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        outerObj.localClassExample();
    }
}
