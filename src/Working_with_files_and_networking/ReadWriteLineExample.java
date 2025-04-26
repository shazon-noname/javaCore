package src.Working_with_files_and_networking;

import java.io.*;

public class ReadWriteLineExample {
    public static void main() throws IOException {
        try (FileInputStream fis = new FileInputStream("logback.xml");
             Reader reader = new InputStreamReader(fis);
             BufferedReader bufferedReader = new BufferedReader(reader);

             FileOutputStream fileOutputStream = new FileOutputStream("testLogBack.xml");
             Writer writer = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }
}
