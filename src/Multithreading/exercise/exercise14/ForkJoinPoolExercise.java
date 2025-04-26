package src.Multithreading.exercise.exercise14;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExercise {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        int sum = forkJoinPool.invoke(new Worker(array, 0, array.length));
        System.out.println(sum);

    }

    static class Worker extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        Worker(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 2) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int middle = (end + start) / 2;
                Worker firstHalfWork = new Worker(array, start, middle);
                Worker secondHalfWork = new Worker(array, middle, end);
                invokeAll(firstHalfWork, secondHalfWork);
                return firstHalfWork.join() + secondHalfWork.join();
            }
        }
    }
}
