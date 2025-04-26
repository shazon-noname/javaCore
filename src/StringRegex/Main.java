package src.StringRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String number = "А674МР197";
        String lettersRange = "[АВЕКМНОРСТУХ]";
        String intRange = "[0-9]";
        String regex = lettersRange + intRange + "{3}" + lettersRange + "{2}" + intRange + "{2,3}";
        System.out.println(number.matches(regex));

        String phone1 = "+7 903 712-37-54";
        String phone2 = "7 (903) 968-60-45";
        String phone3 = "7999-666-66-66";
        String phone4 = "7(903)9616245";
        System.out.println(formatPhoneNumber(phone1) + System.lineSeparator());

        String text = "I know something about it";
        String[] resultWords = formatString(text);
        for (String word : resultWords) {
            System.out.println(word);
        }

        System.out.println();

        String textParse = "Алексей, добрый день!\nМой гитхаб — https://github.com/, а также ссылка на мой персональный сайт — https://www.skillbox.ru/\nЕсли возникнут вопросы, пишите мне напрямую. Я всегда доступен";
        System.out.println(findUrlInString(textParse) + System.lineSeparator());

        String textParse1 = "Дмитрий сообщил следующее: «Я вернусь в 12:40 и, будьте добры, подготовьте к этому времени все документы!» На что Анна ему ответила: «А документы-то так и не привезли». Дмитрий удивлённо посмотрел на неё и сказал: «Ну и ладно», — вздохнул, махнул рукой и удалился.";
        System.out.println(findQuotations(textParse1) + System.lineSeparator());

    }

    public static ArrayList<String> findQuotations(String text) {
        String regex = "«([^»]+)»";
        ArrayList<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            result.add(matcher.group(1));
        }

        return result;
     }

    public static ArrayList<String> findUrlInString(String text) {
        String regex = "https://[^,\\s]+";

        ArrayList<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            result.add(text.substring(start,end));
            result.add(matcher.group());
        }

        return result;
    }

    public static String[] formatString(String text) {
        return text.split("\\s");
    }

    public static String formatPhoneNumber(String phone) {
        String regex = "[^0-9]";
        return phone.replaceAll(regex, "");
    }
}
