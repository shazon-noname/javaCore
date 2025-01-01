package NumberAndDateExperiments;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println(afterDate());
    }

    public static String afterDate () {
        LocalDate birthdayJava = LocalDate.of(1995, 5, 23);
        Period period = birthdayJava.until(LocalDate.now());
        return period.getYears() + " years, " +
                period.getMonths() + " months, " +
                period.getDays() + " days";
    }
}
