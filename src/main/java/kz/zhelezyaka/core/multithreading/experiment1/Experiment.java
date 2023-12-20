package kz.zhelezyaka.core.multithreading.experiment1;

import static java.lang.System.*;

public class Experiment {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.run();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            out.println("Thread: " + i);
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            out.println("Runnable: " + i);
        }
    }
}
