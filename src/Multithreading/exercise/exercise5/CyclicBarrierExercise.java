package src.Multithreading.exercise.exercise5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for each other.
The barrier is called cyclic because it can be re-used after the waiting threads are released.
A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread in the party arrives, but before any threads are released.
This barrier action is useful for updating shared-state before any of the parties continue.

Write a Java program to showcase the usage of the CyclicBarrier class for thread synchronization.
 */
public class CyclicBarrierExercise {
    private static final int NUM_THREAD = 3;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_THREAD, new BarrierAction());

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREAD];
        for (int i = 0; i < NUM_THREAD; i++) {
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

    }


    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting at the barrier.");
                cyclicBarrier.await();

                // Perform work after reaching the barrier

                System.out.println("Thread " + Thread.currentThread().getName() + " has crossed the barrier and continued execution.");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class BarrierAction implements Runnable {

        @Override
        public void run() {
            System.out.println("Barrier reached! All threads have arrived at the barrier.");
        }
    }
}
