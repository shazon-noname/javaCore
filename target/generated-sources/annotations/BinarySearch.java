package src.algos;

public class BinarySearch {
    static int count = 0;
    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13};

    static int binaryMethodFindElement(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;
        int middle;
        int position = -1;
        boolean found = false;
        while (start <= end) {
            count++;
            middle = (int) Math.floor((start + end) / 2);
            if (array[middle] == element) {
                found = true;
                position = middle;
                break;
            } else if (element < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return position;
    }

    public static int recursiveBinaryMethodFindElement(int[] array, int element, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        count++;
        if (array[middle] == element) {
            return middle;
        }
        if (element < array[middle]) {
            return recursiveBinaryMethodFindElement(array, element, start,middle-1);
        } else {
            return recursiveBinaryMethodFindElement(array, element, middle+1, end);
        }
    }

    public static void main(String[] args) {
//        int result = binaryMethodFindElement(array, 13);
        int result2 = recursiveBinaryMethodFindElement(array, 13, 0, array.length-1);
        System.out.println("result = " + result2 + "\n" + "count = " + count);
    }
}
