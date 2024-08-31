package algos;

import java.util.Arrays;

public class SelectionSort {
    static int[] array = {0,5,7,3,1,2,5,7,90,-2,-4,5};
    static  int count = 0;
    public static void main(String[] args) {

        System.out.println(Arrays.toString(selectionSortArray(array)));
        System.out.println(count);
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
