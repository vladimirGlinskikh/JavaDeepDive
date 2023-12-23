package kz.zhelezyaka.core.multithreading.experiment8;

import java.util.concurrent.Semaphore;

import static java.lang.System.*;

public class Experiment {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new User("Vladimir", semaphore);
        new User("Pavel", semaphore);
        new User("Anastasia", semaphore);
        new User("Leonid", semaphore);
        new User("Maxim", semaphore);
    }
}

class User extends Thread {
    String name;
    private final Semaphore phoneBooth;

    public User(String name, Semaphore phoneBooth) {
        this.name = name;
        this.phoneBooth = phoneBooth;
        this.start();
    }

    @Override
    public void run() {
        try {
            out.println(name + " Ждет очередь позвонить...");
            phoneBooth.acquire();
            out.println(name + " зашел в телефонную будку");
            sleep(3_000);
            out.println(name + " завершил звонок и вышел из будки");
        } catch (InterruptedException e) {
            err.println();
        } finally {
            phoneBooth.release();
        }
    }
}
