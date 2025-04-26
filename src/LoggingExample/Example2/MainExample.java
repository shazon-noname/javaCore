package src.LoggingExample.Example2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Logger;



// can use sonarQube
//java -verbose src.LoggingExample.Example.Test.java

public class MainExample {
    private static Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws FileNotFoundException {
        Random random = new Random() {
            @Override
            public double nextDouble() {
                Double d = super.nextDouble();
                System.out.println(d); // можу побачити через анонімний клас, що повертає метод, до якого немає доступу
                return d;
            }
        };
        // Виклик метода nextDouble(), щоб побачити результат
        double value = random.nextDouble();
        System.out.println("Returned value: " + value);


        methodTest();



    }
    private static void methodTest2() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //save to file
            }
        });
    }


    private static void methodTest() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("ingest.log");
        new Throwable().printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
//        Thread.dumpStack();
//        try {
//            throw new Exception("message");
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            e.printStackTrace();
//        }
       }
}
