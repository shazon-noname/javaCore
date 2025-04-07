package Working_with_files_and_networking;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExampleMp {
    public static void main() throws IOException {
        FileInputStream is = new FileInputStream("working_with_files_and_networking/cats.mp4");
        FileOutputStream os = new FileOutputStream("working_with_files_and_networking/cats2.mp4");

        byte[] buffer = new byte[4096];
        int read = is.read(buffer);
        while (read != -1) {
            os.write(buffer,0,read);
            read = is.read(buffer);
        }
        is.close();
        os.close();
    }
}
