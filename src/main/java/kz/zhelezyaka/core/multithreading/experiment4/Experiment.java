package kz.zhelezyaka.core.multithreading.experiment4;

import static java.lang.System.*;

public class Experiment {
    public static void main(String[] args) {
        RunnableImp runnable = new RunnableImp();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImp implements Runnable {
    public synchronized void increment() {
        Counter.count++;
        out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            increment();
        }
    }
}

class Counter {
    static int count = 0;
}
