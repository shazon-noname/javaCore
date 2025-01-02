package StringRegex;

public class SequentialWordsNumbers {

    public static void main(String[] args) {
        sequentialWordsNumbers("Это просто текст, для примера работы программы");
    }

    public static void sequentialWordsNumbers(String string) {
        String[] result = string.split(" ");
        for (int i = 0; i < result.length; i++) {
            System.out.print("(" + ++i + ") " + result[--i] + " ");
        }

    }
}
