package algos;

import java.util.Arrays;

public class SelectionSort {
    static int[] array = {0, 5, 7, 3, 1, 2, 5, 7, 90, -2, -4, 5};
    static int[] array2 = {0, 5, 7, 3, 1, 2, 5, 7, 90, -2, -4, 5};
    static int[] array3 = {0, 5, 7, 3, 1, 2, 5, 7, 90, -2, -4, 5};
    static int count = 0;
    static int count2 = 0;
    static int count3 = 0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSortArray(array)));
        System.out.println(count);

        selectSortArray2();
        System.out.println(Arrays.toString(array2));
        System.out.println(count2);

        System.out.println(Arrays.toString(selectionSortArray3(array3)));
        System.out.println(count3);
    }

    private static void selectSortArray2() {
        for (int step = 0; step < array2.length; step++) {
            count2++;
            int index = min(array2, step);
            int temp = array2[step];
            array2[step] = array2[index];
            array2[index] = temp;
        }
    }

    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[minIndex];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int[] selectionSortArray3(int[] array) {
        for (int step = 0; step < array.length; step++) {
            count3++;
            int minIndex = step;

            for (int i = step + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }

            if (minIndex != step) {
                int temp = array[step];
                array[step] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    private static int[] selectionSortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
                count++;
            }
            int tmp = array[i];
            array[i] = array[indexMin];
            array[indexMin] = tmp;
        }
        return array;
    }
}
