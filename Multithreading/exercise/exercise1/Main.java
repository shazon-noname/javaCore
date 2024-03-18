package Multithreading.exercise.exercise1;
/*
Write a Java program to create and start multiple threads that increment a shared counter variable concurrently.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int numThread = 12;
        int incrementsPerThreads = 10_000;
        IncrementThread[] threads = new IncrementThread[numThread];
        for (int i = 0; i < numThread; i++) {
            threads[i] = new IncrementThread(counter, incrementsPerThreads);
            threads[i].start();
        }

        for (IncrementThread thread : threads) {
            thread.join();
        }

        System.out.println(counter.getCount());

    }
}
