package Multithreading.ForkJoinFramework;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStreamSpliterator {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int MAX = 8;
        List<Integer> test = IntStream.range(1, MAX + 1).boxed().toList();

//        Spliterator<Integer> sp1 = test.spliterator();
//        Spliterator<Integer> sp2 = sp1.trySplit();
//        Spliterator<Integer> sp3 = sp1.trySplit();
//        Spliterator<Integer> sp4 = sp2.trySplit();
//        sp1.forEachRemaining(i -> System.out.println(i));
//        System.out.println("-----------------");
//        sp2.forEachRemaining(i -> System.out.println(i));
//        System.out.println("-----------------");
//        sp3.forEachRemaining(i -> System.out.println(i));
//        System.out.println("-----------------");
//        sp4.forEachRemaining(i -> System.out.println(i));
//        System.out.println("-----------------");
        ForkJoinPool forkJoinPool = new ForkJoinPool(MAX);
        forkJoinPool.submit(() ->
                test.parallelStream()
                        .forEach(i -> {
                            System.out.println("Start: " + Thread.currentThread().getId() + ":" + i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Finish: " + Thread.currentThread().getId() + ":" + i);
                        })).get();
    }
}
