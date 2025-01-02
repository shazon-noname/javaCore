package StringRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitText {
    public static void main(String[] args) {
        String text = "This is a sample text with some numbers 123 and punctuation! Let's split it into words.";
        System.out.println(splitTextIntoWords(text));
    }

    public static String splitTextIntoWords(String text) {
        String regex = "\\b[a-zA-Z]+\\b";

        List<String> words = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return String.join("\n", words);
    }
}
