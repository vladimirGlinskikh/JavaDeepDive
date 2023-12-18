package kz.zhelezyaka.core.clone.copyconstructor;

import lombok.Getter;
import lombok.Setter;

import static java.lang.System.*;

@Setter
@Getter
class SomeClass {
    private int value;

    public SomeClass(int value) {
        this.value = value;
    }

    //    конструктор копирования
    public SomeClass(SomeClass original) {
        this.value = original.value;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объект SomeClass
        SomeClass original = new SomeClass(43);

        // Используем сгенерированный getter
        out.println("Original value: " + original.getValue());

        // Создаем копию объекта с помощью конструктора копирования
        SomeClass copy = new SomeClass(original);

        // Используем сгенерированный getter для копии
        out.println("Copy value: " + copy.getValue());

        // Изменяем значение в оригинале
        original.setValue(99);

        // Проверяем, что значение в копии осталось прежним
        out.println("Original value after modification: " + original.getValue());
        out.println("Copy value after modification in original: " + copy.getValue());
    }
}
