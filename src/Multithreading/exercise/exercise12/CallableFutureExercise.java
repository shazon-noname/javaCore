package src.Multithreading.exercise.exercise12;

import java.util.Arrays;
import java.util.concurrent.*;

public class CallableFutureExercise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<int[]> future = executor.submit(new FutureTask(5));
        int[] result = future.get();
        System.out.println("Task result: " + Arrays.toString(result));
        executor.shutdown();
    }


    static class FutureTask implements Callable<int[]> {
        private final int count;

        FutureTask(int count) {
            this.count = count;
        }

        @Override
        public int[] call() throws Exception {
            int[] arr = new int[count];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i < count; ++i) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr;
        }
    }
}

