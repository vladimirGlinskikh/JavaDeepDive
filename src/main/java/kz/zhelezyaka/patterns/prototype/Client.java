package kz.zhelezyaka.patterns.prototype;

// Интерфейс прототипа
interface Prototype {
    Prototype clone();
}

// Конкретный класс, реализующий прототип
class ConcretePrototype implements Prototype {
    private String name;

    public ConcretePrototype(String name) {
        this.name = name;
    }

    // Метод для клонирования
    @Override
    public Prototype clone() {
        return new ConcretePrototype(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Name: " + name);
    }
}

public class Client {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("Vladimir");

        // Используем прототип для создания копии
        ConcretePrototype copy = (ConcretePrototype) original.clone();

        original.display();
        copy.display();
    }
}
