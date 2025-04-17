package Working_with_files_and_networking.JavaNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RecursiveAsyncFileWriter {
    private static final String[] MESSAGE = {"First line\n",
            "Second line\n",
            "Third line\n",
            "Fourth line\n"};
    private static int currentIndex = 0;
    private static long filePosition = 0;

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("Working_with_files_and_networking/JavaNIO/RecurciveText.txt");
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(
                path,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        );

        writeNextLine(asynchronousFileChannel);

        System.out.println("Asynchronous recording has started...");
        try {
            Thread.sleep(2000); // Даємо час на запис
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void writeNextLine(AsynchronousFileChannel asynchronousFileChannel) {
        if (currentIndex >= MESSAGE.length) {
            System.out.println("all data is recorded");
            try {
                asynchronousFileChannel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        String line = MESSAGE[currentIndex];
        ByteBuffer buffer = ByteBuffer.wrap(line.getBytes());

        asynchronousFileChannel.write(buffer,
                filePosition,
                null,
                new CompletionHandler<Integer, Void>() {
                    @Override
                    public void completed(Integer bytesWritten, Void attachment) {
                        System.out.println("Recorded: \"" + line.trim() + "\" (" + bytesWritten + "bytes)");
                        currentIndex++;
                        filePosition += bytesWritten;
                        writeNextLine(asynchronousFileChannel);
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        System.out.println("Error record: " + exc.getMessage());
                        try {
                            asynchronousFileChannel.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
    }
}
