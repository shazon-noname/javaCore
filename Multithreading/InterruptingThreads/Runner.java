package Multithreading.InterruptingThreads;

import java.util.concurrent.TimeUnit;

/*
    VideoLesson - https://www.youtube.com/watch?v=dxt1aBzsSII&list=PLqnlz-HutZiRA06Y-LdunLtHN7XwBZgNG&index=9
 */

public class Runner {
    private static final String MESSAGE_REQUEST_WAS_SENT = "\n Request was sent";
    private static final String MESSAGE_THREAD_IS_INTERRUPTED = "Thread was interrupted";
    private static final String MESSAGE_RESPONSE_WAS_RECEIVED = "Response was received";
    private static final String MESSAGE_SERVER_WAS_STOPPED = "Server was stopped";
    private static final int DURATION_IN_SECONDS_DELIVERING_RESPONSE = 1;
    private static final int TIME_WAITING_IN_SECONDS_TO_START_STOPPING_THREAD = 4;

    public static void main(String[] args) throws InterruptedException {
        final Thread communicatingThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    doRequest();
                }
            } catch (InterruptedException e) {
                System.out.println(MESSAGE_THREAD_IS_INTERRUPTED);
            }
        });
        communicatingThread.start();

        final Thread stoppingThread = new Thread(() -> {
            if (isServerShouldBeOffed()) {
                communicatingThread.interrupt();
                stopServer();
            }
        });
        TimeUnit.SECONDS.sleep(TIME_WAITING_IN_SECONDS_TO_START_STOPPING_THREAD);
        stoppingThread.start();
    }

    private static void doRequest() throws InterruptedException {
        System.out.println(MESSAGE_REQUEST_WAS_SENT);
        TimeUnit.SECONDS.sleep(DURATION_IN_SECONDS_DELIVERING_RESPONSE);
        System.out.println(MESSAGE_RESPONSE_WAS_RECEIVED);

    }

    private static boolean isServerShouldBeOffed() {
        return true;
    }

    private static void stopServer() {
        System.out.println(MESSAGE_SERVER_WAS_STOPPED);
    }
}
