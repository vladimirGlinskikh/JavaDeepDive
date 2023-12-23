package kz.zhelezyaka.core.multithreading.experiment7;

import java.util.concurrent.ExecutorService;

import static java.lang.System.*;
import static java.util.concurrent.Executors.*;

public class Experiment {
    public static void main(String[] args) {
        try (ExecutorService executorService = newFixedThreadPool(7)) {
            for (int i = 0; i < 10; i++) {
                executorService.execute(new RunnableImpl());
            }
        }
        out.println("Experiment ends");
    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            err.println();
        }
    }
}
