package src.algos;

import java.util.Arrays;

public class QuickSort4 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 4, 4768, 12, 31, 123};
//        quickSort(array, 0, array.length - 1);
//        bubbleSort(array);
        test();
//        System.out.println(Arrays.toString(array));
    }


    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i-1, i);
                    sorted = false;
                }
            }
        }
    }

    public static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);

//            printSortStep(array, from, to, divideIndex);

            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }
    }

    public static int partition(int[] array, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        int pivot = array[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(Arrays.toString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + Arrays.toString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + Arrays.toString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }


    public static void test() {
        int testLen = 10_000;
        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        for (int i = 0; i < testLen; i++) {
            arr1[i] = arr2[i] = (int) Math.round(Math.random() * 10_000);
        }
        System.out.print(" Quick sort ");
        measureTime(() -> quickSort(arr1, 0, arr1.length - 1));

        System.out.print(" Bubble sort ");
        measureTime(() -> bubbleSort(arr2));


    }

    public static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Time spent = " + elapsed + " ms");
    }

}
