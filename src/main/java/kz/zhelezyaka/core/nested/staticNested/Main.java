package kz.zhelezyaka.core.nested.staticNested;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

class Order {
    private final int orderId;
    private final List<OrderItem> orderItems;

    public Order(int orderId) {
        this.orderId = orderId;
        this.orderItems = new ArrayList<>();
    }

    // Вложенный класс представляет позицию товара в заказе
    static class OrderItem {
        private final String productName;
        private final int quantity;
        private final double price;

        public OrderItem(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public double getTotalPrice() {
            return quantity * price;
        }

        @Override
        public String toString() {
            return quantity + "x " + productName + " - $" + getTotalPrice();
        }
    }

    // Метод для добавления товара в заказ
    public void addItem(String productName, int quantity, double price) {
        OrderItem orderItem = new OrderItem(productName, quantity, price);
        orderItems.add(orderItem);
    }

    // Метод для вывода информации о заказе
    public void displayOrder() {
        out.println("Order № " + orderId);
        out.println("Items:");
        for (OrderItem orderItem : orderItems) {
            out.println(orderItem);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем заказ
        Order order = new Order(1);

        // Добавляем товары в заказ с использованием вложенного класса
        order.addItem("Laptop", 2, 1200.0);
        order.addItem("Mouse", 3, 25.0);

        // Выводим информацию о заказе
        order.displayOrder();
    }
}
