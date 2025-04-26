package src.NumberAndDateExperiments;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Timestamp {
    public static void main(String[] args) {
        extracted();
        extracted1();
        extracted2();

    }

    private static void extracted2() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toEpochSecond(ZoneOffset.ofHours(2)));
    }

    private static void extracted1() {
        LocalDateTime now = LocalDateTime.ofEpochSecond(System.currentTimeMillis() / 1000, 0, ZoneOffset.ofHours(2));
        System.out.println(now);
    }

    private static void extracted() {
        long start = System.currentTimeMillis();

        String line = "";
        for (int i = 0; i < 10000; i++) {
            line+=Math.random();
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
