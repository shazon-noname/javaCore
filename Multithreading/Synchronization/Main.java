package Multithreading.Synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.setResource(resource);
        myThread2.setResource(resource);
        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
//        System.out.println(resource.i);
        System.out.println(Resource.j);
    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
//        resource.changeI();
        Resource.changeStaticJ();
    }
}

class Resource {
    int i;
    static int j;

    public void changeI() {
        synchronized (this) {
            int i = this.i;
            i++;
            this.i = i;
        }
    }


    public static void changeStaticJ() {
        synchronized (Resource.class) {
            int j = Resource.j;
            j++;
            Resource.j = j;
        }
    }
}