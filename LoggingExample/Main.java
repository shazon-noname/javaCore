package LoggingExample;

import LombokPractice.App;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        int x = 10;
        logger.info("x = {}", x);
        logger.debug("Debug message is written in console");
        logger.info("Info message is written to stdout.log");
        logger.error("Error message is written to stderr.log");
    }
}
