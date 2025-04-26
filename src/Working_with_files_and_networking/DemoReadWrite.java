package src.Working_with_files_and_networking;

import java.io.*;

public class DemoReadWrite {
    public static void main() {
        try (Reader reader = new FileReader("log4j2.xml");
             Writer writer = new FileWriter("Working_with_files_and_networking/testLog.xml")) {
            char[] buffer = new char[4096];
            int r = reader.read(buffer);
            while (r != -1) {
                writer.write(buffer, 0, r);
                r = reader.read(buffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
