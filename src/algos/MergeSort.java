package src.algos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {12,13,1,345,43,23,6};
        mergeSort(array);
    }

    public static int[] mergeSort(int[] array) {
        int[] temp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;

        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            temp = currentSrc;
            currentSrc = currentDest;
            currentDest = temp;

            size = 2 * size;

            System.out.println(Arrays.toString(currentSrc));
        }


        return currentSrc;
    }


    public static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                             int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = (src1End - src1Start) + (src2End - src2Start);

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }

    }
}
