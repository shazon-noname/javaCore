package src.algos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 7};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}
