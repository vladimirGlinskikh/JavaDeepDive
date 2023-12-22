package kz.zhelezyaka.core.multithreading.experiment5;

import static java.lang.System.*;

public class Experiment {
    public static void main(String[] args) {
        RunnableExample runnable = new RunnableExample();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableExample implements Runnable {

    private void someWork() {
        out.println("Some work is here");
    }

    public void increment() {
        someWork();
        synchronized (this) {
            Counter.count++;
            out.print(Counter.count + " ");
        }
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
