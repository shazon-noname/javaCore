package src.Working_with_files_and_networking;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Example3 {
    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter("Working_with_files_and_networking/text2.txt");
            for (int i = 0; i < 1000; i++) {
                printWriter.write(i + "\n");
            }
            printWriter.flush();
            printWriter.close();


            ArrayList<String> stringArraylist = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                stringArraylist.add(Integer.toString(i));
            }
            Files.write(Paths.get("Working_with_files_and_networking/text2.1.txt"), stringArraylist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
