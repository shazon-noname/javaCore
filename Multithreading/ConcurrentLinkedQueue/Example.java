package Multithreading.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Example {
    public static void main() {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Thread producer1 = new Thread(new Producer(concurrentLinkedQueue,"Producer : 1"));
        Thread producer2 = new Thread(new Producer(concurrentLinkedQueue,"Producer : 2"));

        Thread consumer1 = new Thread(new Consumer(concurrentLinkedQueue,"Consumer : 1"));
        Thread consumer2 = new Thread(new Consumer(concurrentLinkedQueue,"Consumer : 2"));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }

    static class Producer implements Runnable {
        private final ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        private final String producerName;
        private int counter ;

        public Producer(ConcurrentLinkedQueue<String> concurrentLinkedQueue, String producerName) {
            this.concurrentLinkedQueue = concurrentLinkedQueue;
            this.producerName = producerName;
            this.counter = 0;
        }


        @Override
        public void run() {
            while (true) {
                String name = producerName + "-Item-" + counter++;
                concurrentLinkedQueue.offer(name);
                System.out.println("Produced: " + name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final ConcurrentLinkedQueue<String> concurrentLinkedQueue;
        private final String consumerName;


        public Consumer(ConcurrentLinkedQueue<String> concurrentLinkedQueue, String producerName) {
            this.concurrentLinkedQueue = concurrentLinkedQueue;
            this.consumerName = producerName;
        }


        @Override
        public void run() {
            while (true) {
                String name = concurrentLinkedQueue.poll();
                if (name != null) {
                    System.out.println(consumerName + " consumed: " + name);
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
