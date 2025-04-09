package Working_with_files_and_networking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class FileExample {

    private static final Logger logger = LoggerFactory.getLogger(FileExample.class.getName());

    public static void main(String[] args) throws IOException {
        File f = new File("Working_with_files_and_networking");
        logger.info("Info message is written to stdout.log");
        if (f.exists()) {
            String[] files = f.list((dir, name) -> name.startsWith("cats"));
            if (files != null && files.length > 0) {
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                logger.error("Not have files");
                logger.debug("Not have files");
            }
        }
        Path p = Paths.get("Working_with_files_and_networking/text.txt");
        Stream<String> stringList = Files.lines(p);
        stringList.forEach((s) -> System.out.println(s));

    }
}


