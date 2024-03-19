package Multithreading.exercise.exercise6;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExercise {
    private static final int NUM_THREADS = 3;
    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch finishLatch = new CountDownLatch(NUM_THREADS);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }

        startLatch.countDown();
        finishLatch.await();

        System.out.println("All threads have finished their work.");
    }

    static class Worker implements Runnable {

        @Override
        public void run() {
            try {
                startLatch.await();
                System.out.println("Thread " + Thread.currentThread().getName() + " has finished its work.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                finishLatch.countDown();
            }
        }
    }
}
