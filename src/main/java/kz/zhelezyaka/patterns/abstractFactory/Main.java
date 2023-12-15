package kz.zhelezyaka.patterns.abstractFactory;

// Абстрактный класс транспортного средства
abstract class Transport {
    abstract void deliver();
}

// Абстрактный класс контейнера
abstract class Container {
    abstract void load();
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

// Конкретные классы для различных типов контейнеров
class TruckContainer extends Container {
    @Override
    void load() {
        System.out.println("Loading on a truck");
    }
}

class ShipContainer extends Container {
    @Override
    void load() {
        System.out.println("Loading on a ship");
    }
}

// Абстрактная фабрика для создания семейства объектов
interface LogisticsFactory {
    Transport createTransport();
    Container createContainer();
}

// Конкретные реализации абстрактной фабрики для каждого типа транспорта
class RoadLogisticsFactory implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Truck();
    }

    @Override
    public Container createContainer() {
        return new TruckContainer();
    }
}

class SeaLogisticsFactory implements LogisticsFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }

    @Override
    public Container createContainer() {
        return new ShipContainer();
    }
}

public class Main {
    public static void main(String[] args) {
        // Используем абстрактную фабрику для создания семейств объектов различных типов транспорта
        LogisticsFactory roadFactory = new RoadLogisticsFactory();
        Transport roadTransport = roadFactory.createTransport();
        roadTransport.deliver();  // Вывод: Delivering by truck
        Container roadContainer = roadFactory.createContainer();
        roadContainer.load();     // Вывод: Loading on a truck

        LogisticsFactory seaFactory = new SeaLogisticsFactory();
        Transport seaTransport = seaFactory.createTransport();
        seaTransport.deliver();   // Вывод: Delivering by ship
        Container seaContainer = seaFactory.createContainer();
        seaContainer.load();      // Вывод: Loading on a ship
    }
}
