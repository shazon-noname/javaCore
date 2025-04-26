package src.ExceptionHandling.example1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        readLineFromFile("");
    }

    public static void readLineFromFile(String fileName) throws IOException {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            reader.readLine();
        } catch (FileNotFoundException e) {
            if (!isFileNameValid(fileName)) {
                throw new InncorrectFileNameException("File name " + fileName + " is not valid");
            } else {
                throw e;
            }
        }
    }

    public static boolean isFileNameValid(String fileName) {
        //checking file name
        return false;
    }
}
