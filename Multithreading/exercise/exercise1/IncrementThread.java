package Multithreading.exercise.exercise1;

public class IncrementThread extends Thread {
    private Counter counter;
    private int incrementPerThreads;

    public IncrementThread(Counter counter, int incrementPerThreads) {
        this.counter = counter;
        this.incrementPerThreads = incrementPerThreads;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementPerThreads; i++) {
            counter.increment();
        }
    }
}
