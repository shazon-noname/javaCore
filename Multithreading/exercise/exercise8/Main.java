package Multithreading.exercise.exercise8;

import java.util.stream.IntStream;

public final class Main {
    private static final int FROM_NUMBER_FIRST_THREAD = 1;
    private static final int TO_NUMBER_FIRST_THREAD = 500;
    private static final int FROM_NUMBER_SECOND_THREAD = 501;
    private static final int TO_NUMBER_SECOND_THREAD = 1000;
    private static final String TEMPLATE_MESSAGE_NUMBER_THREAD = "%s : %d\n";

    public static void main() throws InterruptedException {
        TaskNumberIncrement firstTask = new TaskNumberIncrement(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
        TaskNumberIncrement secondTask = new TaskNumberIncrement(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);

        Thread firstTaskThread = new Thread(firstTask);
        Thread secondTaskThread = new Thread(secondTask);

        startThreads(firstTaskThread, secondTaskThread);

        int result = firstTask.getResultNumber() + secondTask.getResultNumber();

        System.out.printf(TEMPLATE_MESSAGE_NUMBER_THREAD, Thread.currentThread().getName(), result);

    }

    private static void startThreads(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
    }

    private static class TaskNumberIncrement implements Runnable {
        private final int fromNumber;
        private final int toNumber;
        private int resultNumber;

        private TaskNumberIncrement(int fromNumber, int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
        }

        public int getResultNumber() {
            return resultNumber;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(this.fromNumber, this.toNumber).forEach(i -> this.resultNumber += i);
            System.out.printf(TEMPLATE_MESSAGE_NUMBER_THREAD, Thread.currentThread().getName(), this.resultNumber);
        }
    }
}


