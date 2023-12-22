package kz.zhelezyaka.core.multithreading.experiment5;

import lombok.SneakyThrows;

import static java.lang.System.*;

public class Experiment1 {
    static final Object call = new Object();

    @SneakyThrows
    void mobile() {
        synchronized (call) {
            out.println("Mobile call starts");
            Thread.sleep(3_000);
            out.println("Mobile call ends");
        }
    }

    @SneakyThrows
    void skype() {
        synchronized (call) {
            out.println("Skype call starts");
            Thread.sleep(4_000);
            out.println("Skype call ends");
        }
    }

    @SneakyThrows
    void telegram() {
        synchronized (call) {
            out.println("Telegram call starts");
            Thread.sleep(5_000);
            out.println("Telegram call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableMobileImpl());
        Thread thread2 = new Thread(new RunnableSkypeImpl());
        Thread thread3 = new Thread(new RunnableTelegramImpl());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableMobileImpl implements Runnable {

    @Override
    public void run() {
        new Experiment1().mobile();
    }
}

class RunnableSkypeImpl implements Runnable {

    @Override
    public void run() {
        new Experiment1().skype();
    }
}

class RunnableTelegramImpl implements Runnable {

    @Override
    public void run() {
        new Experiment1().telegram();
    }
}
