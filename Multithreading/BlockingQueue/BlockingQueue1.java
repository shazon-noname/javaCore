package Multithreading.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueue1 {
    public static void main(String[] args) {
         BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                queue.add("this is String");
            }
        }.start();
    }
}
