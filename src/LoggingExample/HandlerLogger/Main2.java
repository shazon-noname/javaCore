package src.LoggingExample.HandlerLogger;

import java.io.IOException;
import java.util.logging.*;

public class Main2 {
    private static final Logger logger = Logger.getLogger(Main2.class.getName());

    public static void main(String[] args) throws IOException {
        Handler fileHandler = new FileHandler("%h/myJavaLog.log");
        fileHandler.setFilter(new MyFilter());
        fileHandler.setFormatter(new MyFormatter());
        logger.setUseParentHandlers(false); // немає консоль логера, в данному випадку зберігається тільки в файл.
        logger.addHandler(fileHandler);
        logger.info("info");
        logger.info("info max");

    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + "-" + record.getMessage();
        }
    }


//        System.out.println(System.getProperty("java.util.logging.config.file"));
//        logger.log(Level.FINER,"finer");
//        logger.log(Level.INFO,"info");
//        logger.log(Level.WARNING,"warning",new Throwable());
//        FileHandler fileHandler = new FileHandler();
//        StreamHandler streamHandler = new StreamHandler();
//        ConsoleHandler consoleHandler = new ConsoleHandler();

}
