package kz.zhelezyaka.core.nested.anonymousclass.implementinterface;

import static java.lang.System.*;

interface Greeting {
    void greet();
}

public class AnonymousClassExample {
    public static void main(String[] args) {
        // Использование анонимного класса для реализации интерфейса Greeting
        Greeting anonymousGreeting =
                () -> out.println("Calling from anonymous class!");

        // Вызов метода greet() анонимного класса
        anonymousGreeting.greet();
    }
}
