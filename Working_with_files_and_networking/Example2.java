package Working_with_files_and_networking;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get("Working_with_files_and_networking/text.txt"));
            lines.forEach(line -> stringBuilder.append(line).append("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder);
    }
}
