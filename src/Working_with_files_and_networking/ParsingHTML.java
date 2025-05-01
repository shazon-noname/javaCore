package src.Working_with_files_and_networking;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ParsingHTML {
    public static void main(String[] args) throws IOException {

        try {
            Document document = Jsoup.connect("https://skillbox.ru").get();
            Elements courses = document.select(".ui-header-directions__item");
            courses.forEach(course -> System.out.println(course.text()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        String htmlFile = parseFile("src/Working_with_files_and_networking/code.html");
//        Document document = Jsoup.parse(htmlFile);
//        System.out.println(htmlFile);
    }

    public static String parseFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> stringBuilder.append(line + "\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    // Через Files.readString() (Java 11+)
    public static String parseFile2(String path){
        String content = null;
        try {
            content = Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.endsWith("\n") ? content : content + "\n";
    }

    //Через Files.lines() + Collectors.joining("\n")
    public static String parseFile3(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.joining("\n")) + "\n";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Через BufferedReader
    public static String parseFile4(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    //Через Files.readAllLines() і String.join
    public static String parseFile5(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            return String.join("\n", lines) + "\n";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
