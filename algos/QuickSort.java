package algos;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 5, 6, 8, 23, 9, 4, 6, 4, 1, 7, -1, -5,
                23, -5, 23};
        int[] sortedArr = quickSort(arr);

        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
        System.out.println("\ncount " + count);

    }

    public static int[] quickSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int pivotIndex = array.length / 2;
        int pivot = array[pivotIndex];

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();


        for (int i = 0; i < array.length; i++) {
            count++;
            if (i == pivotIndex) {
                continue;
            }
            if (array[i] < pivot) {
                less.add(array[i]);
            } else {
                greater.add(array[i]);
            }
        }

        int[] sortedLess = quickSort(less.stream().mapToInt(Integer::intValue).toArray());
        int[] sortedGreater = quickSort(greater.stream().mapToInt(Integer::intValue).toArray());

        int[] sortedArray = new int[sortedLess.length + 1 + sortedGreater.length];

        System.arraycopy(sortedLess, 0, sortedArray, 0, sortedLess.length);

        sortedArray[sortedLess.length] = pivot;

        System.arraycopy(sortedGreater, 0, sortedArray, sortedLess.length + 1, sortedGreater.length);

        return sortedArray;

    }
}







