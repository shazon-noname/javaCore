package src.Multithreading.ThreadLocalRandomAndTimeUnit;

public class ThreadLocalRandomAndTimeUnit {
    static int NUMBER_OF_THREADS = 3;
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(threadDemo);
            threads[i].start();
            threads[i].join();
        }
    }
}

class ThreadDemo implements Runnable {
    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();

    @Override
    public void run() {
        increment();
        if (threadLocalCounter.get() != null) {
            threadLocalCounter.set(threadLocalCounter.get() + 1);
        } else {
            threadLocalCounter.set(0);
        }
        printCounters();
    }

    public synchronized void increment() {
        counter++;
    }

    public void printCounters() {
        System.out.println("Counter: " + counter);
        System.out.println("threadLocalCounter: " + threadLocalCounter.get());
    }
}

