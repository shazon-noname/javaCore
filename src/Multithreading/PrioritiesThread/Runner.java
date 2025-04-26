package src.Multithreading.PrioritiesThread;

import java.util.stream.IntStream;

public class Runner {
    private static final String MESSAGE_MAIN_THREAD_FINISHED = "Main thread is finished";

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTask());
        thread.setPriority(10);
        thread.start();
        System.out.println(MESSAGE_MAIN_THREAD_FINISHED);
    }

    static class ThreadTask implements Runnable {
        private static final int RANGE_MINIMAL_BORDER = 0;
        private static final int RANGE_MAXIMAL_BORDER = 100;
        @Override
        public void run() {
            IntStream.rangeClosed(RANGE_MINIMAL_BORDER,RANGE_MAXIMAL_BORDER).forEach(System.out::println);
        }
    }
}
