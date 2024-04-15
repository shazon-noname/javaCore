package Multithreading.exercise.exercise10;

import java.util.concurrent.Phaser;

public class PhaserExercise {
    public static void main() {
        Phaser phaser = new Phaser();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker("Thread" + i, phaser));
            threads[i].start();
        }

    }

    static class Worker implements Runnable {
        private final String name;
        private final Phaser phaser;

        Worker(String name, Phaser phaser) {
            this.name = name;
            this.phaser = phaser;
            phaser.register();
        }

        @Override
        public void run() {
            System.out.println(name + " starting phase 1");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " perfoming phase 1 tasks");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " starting phase 2");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " perfoming phase 2 tasks");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " completed all phaser");
            phaser.arriveAndDeregister();
        }
    }
}
