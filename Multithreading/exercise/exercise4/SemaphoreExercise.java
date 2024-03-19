package Multithreading.exercise.exercise4;


import java.util.concurrent.Semaphore;
/*
From Wikipedia -
In computer science, a semaphore is a variable or abstract data type used to control access to a common resource by multiple
threads and avoid critical section problems in a concurrent system such as a multitasking operating system.
Semaphores are a type of synchronization primitive.

Write a Java program to demonstrate Semaphore usage for thread synchronization.
 */
public class SemaphoreExercise {
    private static final int NUM_THREAD = 6;
    private static final int NUM_PERMITS = 2;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(NUM_PERMITS);
        Thread[] threads = new Thread[NUM_THREAD];
        for (int i = 0; i < NUM_THREAD; i++) {
            threads[i] = new Thread(new Worker(semaphore));
            threads[i].start();
        }
    }

    static class Worker implements Runnable {
        Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                String nameThread = Thread.currentThread().getName();
                System.out.println(nameThread + " acquired the semaphore");
                Thread.sleep(500); // imitation working
                System.out.println(nameThread + " released  the semaphore");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
