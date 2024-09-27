package algos;

import java.util.Arrays;

public class QuickSort4 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 4, 4768, 12, 31, 123};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);

            printSortStep(array,from,to,divideIndex);
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
        System.out.println(", right: " +  Arrays.toString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }
}
