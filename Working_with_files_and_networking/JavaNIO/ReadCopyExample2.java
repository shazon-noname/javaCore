package Working_with_files_and_networking.JavaNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadCopyExample2 {
    public static void main(String[] args) {
        Path inputPath = Paths.get("Working_with_files_and_networking/JavaNIO/input.txt");
        Path outputPath = Paths.get("Working_with_files_and_networking/JavaNIO/output.txt");
        try (FileChannel inputChannel = FileChannel.open(inputPath, StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outputPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (inputChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                outputChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
