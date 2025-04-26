package src.Multithreading.exercise.exercise11;

import java.util.concurrent.Exchanger;

public class ExchangerExercise {
    public static void main() {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(exchanger, "Data from Thread " + i));
            threads[i].start();
        }
    }

    static class Worker implements Runnable {
        private final Exchanger<String> exchanger;
        private final String data;

        public Worker(Exchanger<String> exchanger, String data) {
            this.exchanger = exchanger;
            this.data = data;
        }


        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + " sending data: " + data);
                String receivedData = exchanger.exchange(data); // Exchange data with the other thread

                System.out.println(threadName + " received data: " + receivedData);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
