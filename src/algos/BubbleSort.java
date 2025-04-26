package src.algos;

import java.util.Arrays;

public class BubbleSort {
    static int[] array = {0, 5, 7, 3, 1, 2, 5, 7, 90, -2, -4, 5};
    static int count = 0;

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(bubbleSortArray(array)));
//        System.out.println(count);
        System.out.println(Arrays.toString(bubbleSortArray2(array)));
        System.out.println(count);
    }


    static int[] bubbleSortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                count++;
            }
        }
        return array;
    }

    static int[] bubbleSortArray2(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = true;
                }
                count++;
            }
        }
        return array;
    }
}
