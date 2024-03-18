package Multithreading.exercise.exercise2;// ProducerConsumer.java

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private final static int MAX_ITERATIONS = 15;
    private static volatile int iterationCount = 0;
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());
        producerThread.start();
        consumerThread.start();;

    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (iterationCount < MAX_ITERATIONS) {
                synchronized (buffer) {
                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (iterationCount >= MAX_ITERATIONS && buffer.isEmpty()) {
                        break;
                    }
                    System.out.println("Producer produced: " + iterationCount);
                    buffer.add(iterationCount++);
                    buffer.notifyAll();
                    try {
                        Thread.sleep(500);
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
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    int value = buffer.poll();
                    System.out.println("Consumer consumed: " + value);
                    buffer.notifyAll();
                    if (iterationCount >= MAX_ITERATIONS && buffer.isEmpty()) {
                        break;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}