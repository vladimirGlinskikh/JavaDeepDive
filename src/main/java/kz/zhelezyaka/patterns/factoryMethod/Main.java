package kz.zhelezyaka.patterns.factoryMethod;

// Абстрактный класс транспортного средства
abstract class Transport {
    abstract void deliver();
}

// Конкретные классы для различных типов транспорта
class Truck extends Transport {
    @Override
    void deliver() {
        System.out.println("Delivering by truck");
    }
}

class Ship extends Transport {
    @Override
    void deliver() {
        System.out.println("Delivering by ship");
    }
}

// Интерфейс для фабричного метода
interface TransportFactory {
    Transport createTransport();
}

// Конкретные реализации фабричного метода для каждого типа транспорта
class TruckFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class ShipFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

public class Main {
    public static void main(String[] args) {
        // Используем фабричный метод для создания объектов различных типов транспорта
        TransportFactory truckFactory = new TruckFactory();
        Transport truck = truckFactory.createTransport();
        truck.deliver();  // Вывод: Delivering by truck

        TransportFactory shipFactory = new ShipFactory();
        Transport ship = shipFactory.createTransport();
        ship.deliver();   // Вывод: Delivering by ship
    }
}
