package kz.zhelezyaka.core.multithreading.experiment3;

import static java.lang.System.*;

public class Experiment extends Thread {
   volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        out.println("Loop is finished. Counter: " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Experiment thread = new Experiment();
        thread.start();
        Thread.sleep(5_000);
        out.println("Wake up after 5 seconds");
        thread.b = false;
        thread.join();
        out.println("End of the program.");
    }
}
