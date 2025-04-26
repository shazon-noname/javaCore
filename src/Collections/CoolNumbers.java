package src.Collections;

import java.util.*;

public class CoolNumbers {

    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private static final int MAX_NUMBERS = 2_000_000;


    public static List<String> generateCoolNumbers() {
        List<String> numbers = new ArrayList<>();

        // Generate combinations of numbers.
        outerLoop:
        for (String firstLetter : LETTERS) {
            for (int i = 0; i <= 9; i++) {
                String numberPart = String.format("%d%d%d", i, i, i); // Create a repeated number (e.g., 111)
                for (String secondLetter : LETTERS) {
                    for (String thirdLetter : LETTERS) {
                        for (int region = 1; region <= 199; region++) {
                            String formattedRegion = String.format("%02d", region); // Format region as two digits
                            numbers.add(firstLetter + numberPart + secondLetter + thirdLetter + formattedRegion);
                            if (numbers.size() >= MAX_NUMBERS) break outerLoop; // Stop when max size is reached
                        }
                    }
                }
            }
        }

        System.out.println(numbers);

        System.out.println("Generated " + numbers.size() + " cool numbers.");

        return numbers;
    }


    public static boolean searchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> list, String number) {
        return Collections.binarySearch(list, number) >= 0;
    }

    public static boolean searchInHashSet(Set<String> set, String number) {
        return set.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

    public static void measureSearchTime() {
        List<String> numbers = generateCoolNumbers(); // Generate the list of "cool" numbers
        String testNumber = "А111ВС197"; // Example test number

        // Sort the list for binary search
        Collections.sort(numbers);

        // Measure linear search
        long startTime = System.nanoTime();
        boolean found = searchInList(numbers, testNumber);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Linear search " + (found ? "found" : "not found") + " in " + elapsedTime + " ns");

        // Measure binary search
        startTime = System.nanoTime();
        found = binarySearchInList(numbers, testNumber);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Binary search " + (found ? "found" : "not found") + " in " + elapsedTime + " ns");

        // Measure HashSet search
        Set<String> hashSet = new HashSet<>(numbers);
        startTime = System.nanoTime();
        found = searchInHashSet(hashSet, testNumber);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("HashSet search " + (found ? "found" : "not found") + " in " + elapsedTime + " ns");

        // Measure TreeSet search
        TreeSet<String> treeSet = new TreeSet<>(numbers);
        startTime = System.nanoTime();
        found = searchInTreeSet(treeSet, testNumber);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("TreeSet search " + (found ? "found" : "not found") + " in " + elapsedTime + " ns");
    }

    public static void main(String[] args) {
        measureSearchTime();
    }
}
