package Working_with_files_and_networking.JavaNIO;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadExample {
    public static void main(String[] args) {
        try (FileChannel fileChannel = FileChannel.open(
                Paths.get("Working_with_files_and_networking/JavaNIO/example.txt"),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            ByteBuffer byteBuffer = ByteBuffer.wrap("Hello example.txt".getBytes());
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
