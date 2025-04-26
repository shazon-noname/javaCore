package src.Multithreading.exercise.exercise13;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExercise {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(new Worker(), 2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new Worker(), 1, 5, TimeUnit.SECONDS);
        Thread.sleep(12000);
        executor.shutdown();

    }



    static class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println("Task executed at: " +  new Date());
        }
    }
}
