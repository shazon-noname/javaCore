package src.Working_with_files_and_networking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Example1 {
    private static final Logger LOGGER = Logger.getLogger(Example1.class.getName());

    public static void main(String[] args) {
        String filePath = "C:/Users/marya/IdeaProjects/javaCore/src.Working_with_files_and_networking/text.txt";
        File file = new File(filePath);

        FileHandler fileHandler = null;

        try {
            // Створюємо FileHandler для логування
            fileHandler = new FileHandler("app.log", true); // true, щоб додавати, а не перезаписувати
            fileHandler.setLevel(Level.ALL); // Задаємо рівень логування
            fileHandler.setFormatter(new SimpleFormatter()); // Форматування логів

            LOGGER.addHandler(fileHandler);

            LOGGER.info("Logger initialized successfully.");

            try {
                if (!file.exists()) {
                    File parentDir = file.getParentFile();
                    if (parentDir != null && !parentDir.exists()) {
                        boolean dirsCreated = parentDir.mkdirs();
                        if (!dirsCreated) {
                            LOGGER.warning("Directory was not created: " + parentDir.getAbsolutePath());
                        } else {
                            LOGGER.info("Directory created: " + parentDir.getAbsolutePath());
                        }
                    }
                    boolean created = file.createNewFile();
                    if (created) {
                        LOGGER.info("File was created: " + file.getAbsolutePath());
                        try (FileWriter fileWriter = new FileWriter(file)) {
                            fileWriter.write("Hello world!");
                            LOGGER.info("File written with content.");
                        }
                    } else {
                        LOGGER.warning("File was not created: " + file.getAbsolutePath());
                    }
                } else {
                    LOGGER.info("File already exists: " + file.getAbsolutePath());
                }

                try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                    StringBuilder sb = new StringBuilder();
                    int i;
                    while ((i = fileInputStream.read()) != -1) {
                        sb.append((char) i);
                    }
                    System.out.println(sb);

                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Error reading file", e);
                }

            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error creating file", e);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing the logger", e);
        } finally {
            // Закриваємо FileHandler і викликаємо flush(), щоб зберегти логи
            if (fileHandler != null) {
                fileHandler.flush();
                fileHandler.close();
            }
        }
    }
}