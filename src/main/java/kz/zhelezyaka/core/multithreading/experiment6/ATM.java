package kz.zhelezyaka.core.multithreading.experiment6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.*;

public class ATM {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new User("Vladimir", lock);
        new User("Pavel", lock);
        new User("Maxim", lock);
        new User("Anastasia", lock);
        new User("Leonid", lock);
    }
}

class User extends Thread {
    String name;
    private final Lock lock;

    public User(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        try {
            out.println(name + " ждет очереди...");
            lock.lock();
            out.println(name + " пользуется банкоматом");
            Thread.sleep(3_000);
            out.println(name + " завершил(а) операции с банкоматом");
        } catch (InterruptedException e) {
            err.println();
        } finally {
            lock.unlock();
        }
    }
}
