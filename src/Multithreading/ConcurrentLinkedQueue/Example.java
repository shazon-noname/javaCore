package src.Multithreading.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {
    // Об'єкт для синхронізації виводу
    private static final Lock lock = new ReentrantLock();
    
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        
        // Створюємо виробників
        Thread producer1 = new Thread(new Producer(queue, "Виробник 1"));
        Thread producer2 = new Thread(new Producer(queue, "Виробник 2"));

        // Створюємо споживачів
        Thread consumer1 = new Thread(new Consumer(queue, "Споживач 1"));
        Thread consumer2 = new Thread(new Consumer(queue, "Споживач 2"));

        // Запускаємо всі потоки
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }

    static class Producer implements Runnable {
        private final ConcurrentLinkedQueue<String> queue;
        private final String producerName;
        private int counter;

        public Producer(ConcurrentLinkedQueue<String> queue, String name) {
            this.queue = queue;
            this.producerName = name;
            this.counter = 0;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String item = producerName + "-Елемент-" + (counter++);
                    queue.offer(item);
                    
                    // Синхронізований вивід
                    lock.lock();
                    try {
                        System.out.println("Створено: " + item);
                    } finally {
                        lock.unlock();
                    }
                    
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final ConcurrentLinkedQueue<String> queue;
        private final String consumerName;

        public Consumer(ConcurrentLinkedQueue<String> queue, String name) {
            this.queue = queue;
            this.consumerName = name;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String item = queue.poll();
                    if (item != null) {
                        // Синхронізований вивід
                        lock.lock();
                        try {
                            System.out.println(consumerName + " обробив: " + item);
                        } finally {
                            lock.unlock();
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
