package NumberAndDateExperiments.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Birthdays {
    public static void main(String[] args) {
        System.out.println(collectBirthdays(2002,2,24));
        System.out.println(dataBirth(2002,2,24));
        timestamp();
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


    public static String dataBirth(int year, int month, int day) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .localizedBy(Locale.of("uk"));

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate localDate= LocalDate.now();

        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;

        while (!birthday.isAfter(localDate)) {
            stringBuilder.append(count++)
                    .append(" - ")
                    .append(birthday.format(dateTimeFormatter))
                    .append(" - ")
                    .append(System.lineSeparator());
            birthday = birthday.plusYears(1);
        }

        return stringBuilder.toString();
    }

    public static void timestamp() {
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(System.currentTimeMillis() / 1000,
                0, ZoneOffset.ofHours(2));
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.toEpochSecond(ZoneOffset.ofHours(2)));

    }
}
