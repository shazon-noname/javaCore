package Multithreading.exercise.exercise1;

public class IncrementThread extends Thread {
    private Counter counter;
    private int incrementsPerThreads;

    public IncrementThread(Counter counter, int incrementsPerThreads) {
        this.counter = counter;
        this.incrementsPerThreads = incrementsPerThreads;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementsPerThreads ; i++) {
            counter.increment();
        }
    }
}
