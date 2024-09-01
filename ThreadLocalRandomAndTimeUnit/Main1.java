package ThreadLocalRandomAndTimeUnit;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());

        System.out.println(TimeUnit.DAYS.toHours(14));
    }
}
