package src.algos;

public class FindSecondMinimalElement {
    public static void main(String[] args) {
        int[] array = new int[] {254,23,12,634,32,22,1355};
        findSecondMinimalElement(array);
    }

    public static void findSecondMinimalElement(int[] array) {
        int minimalElement = Integer.MAX_VALUE;
        int minimalSecondElement = Integer.MAX_VALUE;

        for (int j : array) {
            if (j < minimalElement) {
                minimalSecondElement = minimalElement;
                minimalElement = j;
            } else if (j < minimalSecondElement && j != minimalElement) {
                minimalSecondElement = j;
            }
        }

        if (minimalSecondElement != Integer.MAX_VALUE) {
            System.out.println("Другий мінімальний елемент становить = " + minimalSecondElement);
        } else {
            System.out.println("Другий мінімальний елемент відсутній!");
        }

        System.out.println("Мінімальний елемент в масиві = " + minimalElement);
    }
}
