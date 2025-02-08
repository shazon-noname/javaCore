package practice.exercise2;

import java.io.*;
import java.util.*;

public class SynonymDictionary {
    private static final String FILE_NAME = "practice/exercise2/synonyms.txt";
    private static final Map<String, List<String>> dictionary = new HashMap<>();

    public static void main(String[] args) {
        loadDictionary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть слово (або 'exit' для виходу): ");
            String word = scanner.nextLine().trim().toLowerCase();

            if (word.equals("exit")) break;

            if (dictionary.containsKey(word)) {
                System.out.println("Синоніми: " + String.join(", ", dictionary.get(word)));
            } else {
                System.out.println("Слова не найдено в словнику. Введіть для нього синоніми через кому: ");
                String synonymsInput = scanner.nextLine().trim().toLowerCase();
                List<String> synonyms = Arrays.asList(synonymsInput.split(", "));
                dictionary.put(word, synonyms);
                saveToDictionary(word, synonyms);
                System.out.println("Слово добавлено в словник!");
            }
        }
        scanner.close();
    }

    public static void loadDictionary() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    List<String> synonyms = Arrays.asList(parts[1].trim().split(", *"));
                    dictionary.put(word,synonyms);
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при загрузці словника " + e.getMessage());
        }
    }

    public static void saveToDictionary(String word, List<String> synonyms) {
       try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
           bufferedWriter.write(word + " " + String.join(",", synonyms));
           bufferedWriter.newLine();
        } catch (IOException ioException) {
           System.out.println("Помилка при збережені слова в словнику " + ioException.getMessage());
       }
    }
}
