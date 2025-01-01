package SubString;

import java.util.StringJoiner;

public class StringJoinerClass {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        stringJoiner.add("Marian");
        stringJoiner.add("Andriy");
        stringJoiner.add("Serhii");
        System.out.println(stringJoiner);


        String name = "Marian";
        int birthYear = 2002;

        String template = "{\"name\" : \"%s\", \'birthYear\": \"%d\"}";
        String result = String.format(template,name, birthYear);
        System.out.println(result);
    }
}
