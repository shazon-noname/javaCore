package algos;


public class LinearSearch {
    static int count = 0;
    static int[] array = {1, 4, 5, 2, 3, 6, 9, 7, 8, 10, 14, 11};

    static int findElement(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            count++;
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int element = findElement(array, 2);
        System.out.println(element);
        System.out.println("count = " + count);
    }
}


