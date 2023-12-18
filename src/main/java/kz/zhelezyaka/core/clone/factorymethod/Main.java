package kz.zhelezyaka.core.clone.factorymethod;

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

    //   фабричный метод
    public SomeClass copyInstance(SomeClass original) {
        return new SomeClass(original.getValue());
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объект SomeClass
        SomeClass original = new SomeClass(77);

        // Используем getter
        out.println("Original value: " + original.getValue());

        // Создаем копию объекта с помощью фабричного метода
        SomeClass copy = original.copyInstance(original);

        // Используем getter для копии
        out.println("Copy value: " + copy.getValue());

        // Изменяем значение в оригинале
        original.setValue(34);

        // Проверяем, что значение в копии осталось прежним
        out.println("Original value after modification: " + original.getValue());
        out.println("Copy value after modification in original: " + copy.getValue());
    }
}
