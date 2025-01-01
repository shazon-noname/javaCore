package NumberAndDateExperiments.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Birthdays {
    public static void main(String[] args) {
        System.out.println(collectBirthdays(2002,2,24));
    }
    public static String collectBirthdays(int year, int month, int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (birthday.isBefore(today)) {
            String dayOfWeek = birthday.getDayOfWeek().toString().substring(0, 3);
            result.append(count++)
                    .append(" - ")
                    .append(birthday.format(formatter))
                    .append(" - ")
                    .append(dayOfWeek)
                    .append(System.lineSeparator());
            birthday = birthday.plusYears(1);
        }

        return result.toString();
    }
}
