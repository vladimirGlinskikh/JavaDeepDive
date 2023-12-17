package kz.zhelezyaka.core.nested.anonymousclass.extendsclass;

import static java.lang.System.*;

class ParentClass {
    void display() {
        out.println("Parent class display method");
    }
}

public class AnonymousClassExample {
    public static void main(String[] args) {
        // Использование анонимного класса для наследования от ParentClass
        ParentClass anonymousObject = new ParentClass() {
            @Override
            void display() {
                out.println("Anonymous class display method");
            }

            void additionalMethod() {
                out.println("Additional method in anonymous class");
            }
        };

        // Вызов метода display() анонимного класса
        anonymousObject.display();

        // Вызов дополнительного метода анонимного класса
        // (не доступен через ссылку на ParentClass)
        // anonymousObject.additionalMethod();
    }
}
