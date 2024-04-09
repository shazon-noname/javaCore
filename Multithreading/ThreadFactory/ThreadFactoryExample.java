package Multithreading.ThreadFactory;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        threadFactory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
