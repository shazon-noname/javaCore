package Multithreading.DaemonThread;

import java.util.concurrent.TimeUnit;

public class Runner3 {
    private static final int SLEEP_DURATION_IN_SECONDS_IN_MAIN = 1;
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new Task());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(SLEEP_DURATION_IN_SECONDS_IN_MAIN);
    }

    private static final class Task implements Runnable {
        private static final String MESSAGE_START_WORKING = " I am Working";
        private static final String MESSAGE_END_WORKING = " I am Finished";
        private static final int WORKING_DURATION_IN_SECONDS = 5;


        @Override
        public void run() {
            try{
                System.out.println(MESSAGE_START_WORKING);
                TimeUnit.SECONDS.sleep(WORKING_DURATION_IN_SECONDS);

            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println(MESSAGE_END_WORKING);
            }
        }
    }
}
