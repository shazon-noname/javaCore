package Multithreading.exercise.exercise8;

import java.util.stream.IntStream;

public final class Main {
    private static final int FROM_NUMBER_FIRST_THREAD = 1;
    private static final int TO_NUMBER_FIRST_THREAD = 500;
    private static final int FROM_NUMBER_SECOND_THREAD = 501;
    private static final int TO_NUMBER_SECOND_THREAD = 1000;
    private static final String TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER = "%s : %d\n";


    public static void main(String[] args) throws InterruptedException {
        TaskSummingNumbers firstTask = new TaskSummingNumbers(FROM_NUMBER_FIRST_THREAD,TO_NUMBER_FIRST_THREAD);
        TaskSummingNumbers secondTask = new TaskSummingNumbers(FROM_NUMBER_SECOND_THREAD,TO_NUMBER_SECOND_THREAD);

        final Thread thread = new Thread(firstTask);
        final Thread thread1 = new Thread(secondTask);

        thread.start();
        thread1.start();

        waitingForTaskFinished(thread1,thread);

        final int result = firstTask.getResultNumber() + secondTask.getResultNumber();

        printThreadNameAndNumber(result);


    }
    private static void waitingForTaskFinished(final Thread... threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.join();
        }
    }
    private static TaskSummingNumbers startSubTask(final int forNumber, final int toNumber) {
        final TaskSummingNumbers subtask = new TaskSummingNumbers(forNumber, toNumber);
        Thread thread = new Thread(subtask);
        thread.start();
        return subtask;
    }

    private static void printThreadNameAndNumber(final int number) {
        System.out.printf(TEMPLATE_MESSAGE_THREAD_NAME_AND_NUMBER, Thread.currentThread().getName(), number);
    }

    private static final class TaskSummingNumbers implements Runnable {
        private final int INITTIAL_VALUE_RESULT_NUMBER = 0;
        private final int fromNumber;
        private final int toNumber;
        private int resultNumber;


        private TaskSummingNumbers(int fromNumber, int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
            this.resultNumber = INITTIAL_VALUE_RESULT_NUMBER;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(this.fromNumber, this.toNumber).forEach(i -> this.resultNumber += i);
            printThreadNameAndNumber(this.resultNumber);
        }

        public int getResultNumber() {
            return resultNumber;
        }

        public void setResultNumber(int resultNumber) {
            this.resultNumber = resultNumber;
        }
    }

}
