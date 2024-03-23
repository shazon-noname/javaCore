package Multithreading.exercise.exercise3;// SharedResourceExercise.java

import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
Write a Java program that uses the ReentrantLock class to synchronize access to a shared resource among multiple threads.
 */
public class SharedResourceExercise {
    private static int NUM_THREADS = 12;
    private static int NUM_ITERATIONS = 5;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        SharedResources sharedResources = new SharedResources();
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker(lock, sharedResources));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    static class Worker implements Runnable {
        Lock lock;
        SharedResources sharedResources;

        public Worker(Lock lock, SharedResources sharedResources) {
            this.lock = lock;
            this.sharedResources = sharedResources;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                lock.lock();
                try{
                    sharedResources.doWork();
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class SharedResources {
        public void doWork() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is performing work !");
        }
    }
}
