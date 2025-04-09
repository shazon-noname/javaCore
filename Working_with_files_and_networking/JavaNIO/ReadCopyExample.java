package Working_with_files_and_networking.JavaNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadCopyExample {
    public static void main(String[] args) {
//        demoChannel();
        transferDemo();
    }

    private static void transferDemo() {
        try (FileInputStream fileInputStream = new FileInputStream("Working_with_files_and_networking/cats.mp4");
             FileOutputStream fileOutputStream = new FileOutputStream("Working_with_files_and_networking/JavaNIO/cats4.mp4");
             FileChannel inChannel = fileInputStream.getChannel();
             FileChannel outChannel = fileOutputStream.getChannel()) {

            inChannel.transferTo(0, inChannel.size(), outChannel);
//            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void demoChannel() {
        try (FileInputStream fileInputStream = new FileInputStream("Working_with_files_and_networking/cats.mp4");
             FileOutputStream fileOutputStream = new FileOutputStream("Working_with_files_and_networking/JavaNIO/cats3.mp4");
             FileChannel inChannel = fileInputStream.getChannel();
             FileChannel outChannel = fileOutputStream.getChannel()) {

            ByteBuffer inByteBuffer = ByteBuffer.allocate(8198);
            ByteBuffer outByteBuffer = ByteBuffer.allocate(8198);

            int read = inChannel.read(inByteBuffer);
            while (read != -1) {
                inByteBuffer.flip();
                while (inByteBuffer.hasRemaining()) {
                    byte get = inByteBuffer.get();
                    outByteBuffer.put(get);
                }
                outByteBuffer.flip();
                outChannel.write(outByteBuffer);
                inByteBuffer.clear();
                outByteBuffer.clear();
                read = inChannel.read(inByteBuffer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
