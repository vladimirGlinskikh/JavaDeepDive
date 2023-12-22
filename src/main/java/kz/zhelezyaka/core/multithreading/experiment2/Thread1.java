package kz.zhelezyaka.core.multithreading.experiment2;

import static java.lang.System.*;

class Experiment {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.setName("service_thread");
        thread1.setPriority(10);
        out.println("Name of Thread1: " + thread1.getName() + "\n" +
                "Priority of Thread1: " + thread1.getPriority());
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        out.println("thread");
    }
}