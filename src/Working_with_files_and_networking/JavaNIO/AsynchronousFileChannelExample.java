package src.Working_with_files_and_networking.JavaNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsynchronousFileChannelExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("test.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Читання з callback-ом
        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer bytesRead, ByteBuffer buffer) {
                System.out.println("Прочитано " + bytesRead + " байт");
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                System.out.println(new String(data));
            }

            @Override
            public void failed(Throwable exc, ByteBuffer buffer) {
                exc.printStackTrace();
            }
        });

        // Чекаємо завершення (для прикладу)
        Thread.sleep(1000);
        }

    void readFile(AsynchronousFileChannel channel, ByteBuffer buffer, long position) {
        channel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer bytesRead, ByteBuffer buffer) {
                if (bytesRead == -1) {
                    System.out.println("Файл прочитано!");
                    return;
                }

                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                System.out.println(new String(data));

                // Готуємо буфер до наступного читання
                buffer.clear();

                // Читаємо наступну частину
                readFile(channel, buffer, position + bytesRead);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer buffer) {
                exc.printStackTrace();
            }
        });
    }
}
