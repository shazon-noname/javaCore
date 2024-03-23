package Multithreading.ThreadLock;

public class ThreadLockExample {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("Hello world!");

        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadOne();
            threads[i].start();
        }

        for (Thread thread :threads) {
            thread.join();
        }
        Thread threadTwo = new ThreadTwo();
        threadTwo.start();
        threadTwo.join();

        System.out.println(Thread.currentThread().getName() +  " " + threadLocal.get());

    }

    static class ThreadOne extends Thread {
        @Override
        public void run() {
            threadLocal.set("ThreadOne");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currentThread().getName() +  " " + threadLocal.get());
        }
    }

    static class ThreadTwo extends Thread {
        @Override
        public void run() {
            threadLocal.set("ThreadTwo");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currentThread().getName() +  " " + threadLocal.get());
        }
    }
}
