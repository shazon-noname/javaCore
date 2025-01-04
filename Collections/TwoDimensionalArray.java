package Collections;

import java.util.Arrays;

public class TwoDimensionalArray {

    public static void main() {
        char[][] array = getTwoDimensionalArray(13);

        for (char[] element : array) {
            System.out.println(Arrays.toString(element));
        }
    }

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i + j == size - 1 || i == j) {
                    array[i][j] = 'X';
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        return array;
    }
}