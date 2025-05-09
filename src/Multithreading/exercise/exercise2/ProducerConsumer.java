package src.Multithreading.exercise.exercise2;

import java.util.PriorityQueue;
import java.util.Queue;

class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private static final int MAX_ITERATION = 15;
    private static volatile int iterationCount = 1;
    private static final Queue<Integer> buffer = new PriorityQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (iterationCount < MAX_ITERATION) {
                synchronized (buffer) {
                    if (BUFFER_SIZE == buffer.size()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (MAX_ITERATION <= iterationCount && buffer.isEmpty()) {
                        break;
                    }
                    System.out.println("Producer pro = "+ iterationCount);
                    buffer.add(iterationCount++);
                    buffer.notifyAll();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (buffer) {
                    if (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Integer poll = buffer.poll();
                    System.out.println("Consumer cons = " + poll);
                    buffer.notifyAll();
                    if ( MAX_ITERATION <= iterationCount && buffer.isEmpty()) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}




