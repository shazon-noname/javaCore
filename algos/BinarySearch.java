package algos;

public class BinarySearch {
    static int count = 0;
    static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    static int binaryMethodFindElement(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;
        int middle;
        int position = -1;
        boolean found = false;
        while (!found || start <= end) {
            count++;
            middle = (int) Math.floor((start + end) / 2);
            for (int i = 0; i < array.length - 1; i++) {
                if (array[middle] == element) {
                    found = true;
                    position = middle;
                    return position;
                } else if (element < middle) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int result = binaryMethodFindElement(array, 11);
        System.out.println(STR."""
        result = \{result}
        count = \{count}""");
    }
}
