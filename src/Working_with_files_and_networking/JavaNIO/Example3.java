package src.Working_with_files_and_networking.JavaNIO;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Example3 {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(32); // mark = *, position = *, limit = *, capacity = *
        buff.mark(); // mark = *, position = *, limit = *, capacity = *
        buff.put("Byte".getBytes());// mark = *, position = *, limit = *, capacity = *
        buff.reset(); // mark = *, position = *, limit = *, capacity = *
        buff.put("Buffer are part of NIO".getBytes()); // mark = *, position = *, limit = *, capacity = *
        buff.limit(30); // mark = *, position = *, limit = *, capacity = *
        buff.flip(); // mark = *, position = *, limit = *, capacity = *

        byte[] result = new byte[buff.limit()];
        buff.get(result); // mark = *, position = *, limit = *, capacity = *
        System.out.println(new String(result, StandardCharsets.UTF_8)); // ***
    }
}
