package Multithreading.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource1 resource = new Resource1();
        resource.i = 5;
        MyThread1 myThread = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        myThread.setResource(resource);
        myThread2.setResource(resource);
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        System.out.println(resource.i);
        System.out.println(resource.j);
    }
}

class MyThread1 extends Thread {
    Resource1 resource;

    public void setResource(Resource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
        resource.changeJ();

    }
}

class Resource1 {
    int i;
    int j;
    Lock lock = new ReentrantLock();

    void changeI() {
        lock.lock();
        int i = this.i;
        i++;
        this.i = i;
    }
    void changeJ() {
        int j = this.j;
        j++;
        this.j = j;
        lock.unlock();
    }

}