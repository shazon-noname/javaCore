package StringRegex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {
    public static void main(String[] args) {
        System.out.println(numberParse());
    }

    public static String numberParse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phone number:");
        String numberText = scanner.nextLine();

        while (!numberText.startsWith("+380") && numberText.startsWith("0")) {
            System.out.println("Enter your phone number");
            numberText = scanner.nextLine();
        }

        StringBuilder result = new StringBuilder("Input value: ").append(numberText).append("\nOutput value: ");

        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numberText);


        while (matcher.find()) {
            result.append(matcher.group());
        }

        return result.toString();
    }
}
