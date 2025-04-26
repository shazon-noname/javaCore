package src.algos;

import java.util.ArrayList;
import java.util.Arrays;

public class KnuthMorrisPrattAlgorithm {
    public static void main(String[] args) {
        String text = "aabaabaaaaaaabaabaaabababaaaabaab";
        String sample = "aabaab";
        System.out.println(Arrays.toString(searchNaive(text, sample).toArray()));
        System.out.println(Arrays.toString(prefixFunction(sample)));
        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));

    }

    static ArrayList<Integer> searchNaive(String text, String sample) {
        ArrayList<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == sample.length()) {
                foundPositions.add(i);
            }
        }
        return foundPositions;
    }

    static int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        // Ініціалізуємо список, щоб зберігати індекси знайдених входжень підрядка
        ArrayList<Integer> found = new ArrayList<>();
        // Обчислюємо префікс-функцію для підрядка, щоб уникнути повторних порівнянь
        int[] prefixFunc = prefixFunction(sample);
        // Змінні для індексів у тексті (i) та підрядку (j)
        int i = 0;
        int j = 0;
        // Основний цикл, поки не досягнемо кінця тексту
        while (i < text.length()) {
            // Якщо поточні символи підрядка і тексту збігаються
            if (sample.charAt(j) == text.charAt(i)) {
                // Збільшуємо j та i, щоб перевіряти наступні символи
                j++;
                i++;
            }
            // Якщо j досяг довжини підрядка, знайдено повне співпадіння
            if (j == sample.length()) {
                // Додаємо індекс початку збігу у список результатів
                found.add(i - j);
                // Використовуємо префікс-функцію, щоб продовжити пошук з позиції,
                // яка вже частково співпадає, уникнувши зайвих порівнянь
                j = prefixFunc[j - 1];
            }
            // Якщо поточні символи не збігаються, і ми ще не досягли кінця тексту
            else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                // Якщо j не на початковій позиції, використовуємо префікс-функцію,
                // щоб знайти наступну можливу позицію для збігу
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    // Якщо немає часткового збігу, просто рухаємося далі по тексту
                    i = i + 1;
                }
            }
        }

        // Повертаємо список з усіма індексами входжень підрядка у тексті
        return found;
    }

}
