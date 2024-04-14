package Multithreading.exercise.exercise9;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExercise {
    private static final int MAX_ITERATIONS = 5;

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Integer randomInt = (int) (Math.random()*20);

        Thread writer = new Thread(new Writer1(concurrentHashMap, "Thread:1", randomInt));
        Thread writer1 = new Thread(new Writer1(concurrentHashMap, "Thread:2",randomInt*randomInt));

        writer.start();
        writer1.start();

        Thread reader = new Thread(new Reader1(concurrentHashMap, "Thread:1"));
        Thread reader1 = new Thread(new Reader1(concurrentHashMap, "Thread:2"));

        reader.start();
        reader1.start();

        writer.join();
        writer1.join();
        reader.join();
        reader1.join();
    }

    static class Reader1 implements Runnable {
        private final ConcurrentHashMap<String, Integer> map;
        private final String threadName;

        Reader1(ConcurrentHashMap<String, Integer> map, String threadName) {
            this.map = map;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_ITERATIONS; i++) {
                Integer valueMap = map.get(threadName);
                System.out.println(STR."\{threadName} = \{valueMap}");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Writer1 implements Runnable {
        private final ConcurrentHashMap<String, Integer> map;
        private final String threadName;
        private final int value;

        Writer1(ConcurrentHashMap<String, Integer> map, String threadName, int value) {
            this.map = map;
            this.threadName = threadName;
            this.value = value;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_ITERATIONS; i++) {
                map.put(threadName, value);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
