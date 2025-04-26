package src.Collections;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        String[] strings = new String[] {"a", "b", "c", "d"};
        reverse(strings);
        System.out.println(Arrays.toString(strings));
    }

    public static void reverse(String[] string) {
        for (int i = 0; i < string.length / 2; i++) {
            int j = string.length - 1 - i;
            String temp = string[i];
            string[i] = string[j];
            string[j] = temp;
        }
    }
}
