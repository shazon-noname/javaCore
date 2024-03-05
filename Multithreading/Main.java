package Multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        Thread.yield();
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        myRunnableThread.join();
        System.out.println("Main thread = " + Thread.currentThread().getName());
/*
The yield() basically means that the thread is not doing anything particularly important
and if any other threads or processes need to be run,they should run.
Otherwise, the current thread will continue to run.
 */

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable thread =  " + Thread.currentThread().getName());
    }
}


