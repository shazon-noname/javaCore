package src.algos;

import java.util.Arrays;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 78, 4, 8, 32, 123};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int[] array, int low, int high) {
        int leftMarket = low;
        int rightMarker = high;
        int pivot = array[(leftMarket + rightMarker) / 2];

        do {
            while (array[leftMarket] < pivot) {
                leftMarket++;
            }

            while (array[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarket <= rightMarker) {
                if (leftMarket < rightMarker) {
                    int temp = array[leftMarket];
                    array[leftMarket] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarket++;
                rightMarker--;
            }
        } while (leftMarket <= rightMarker);

        if (leftMarket < high) {
            quickSort(array, leftMarket, high);
        }
        if (low < rightMarker) {
            quickSort(array, low, rightMarker);
        }
    }
}
