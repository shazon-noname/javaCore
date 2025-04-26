package src.Working_with_files_and_networking.JavaNIO;

import java.nio.ByteBuffer;

public class Example1 {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(32); //capacity = 32,  mark = -1, position = 0
        buff.position(10); // mark = -1, position = 10
        buff.mark(); // mark = 10, position = 10
        buff.position(20); // mark = 10, position = 20
        buff.reset(); // mark = 10, position = 10

        buff.limit(25); // mark = 10, position = 10, limit = 25
        buff.clear(); // mark = -1, position = 0, limit = 32

        buff.limit(25); // mark = 10, position = 10, limit = 25
        buff.flip(); // mark = -1, position = 0, limit = 10

        buff.limit(25); // mark = 10, position = 10, limit = 25
        buff.rewind(); // mark = -1, position = 0, limit = 25

        buff.limit(25); // mark = 10, position = 10, limit = 25
        buff.compact(); // mark = -1, position = 15, limit = 32

        ByteBuffer secondBuffer = ByteBuffer.allocate(32); // mark = -1, position = 0
        secondBuffer.position(10); // mark = -1, position = 10
        secondBuffer.limit(15); // mark = -1, position = 10, limit = 15
        boolean isRemaining = buff.hasRemaining(); // true
        int remainingSize = buff.remaining(); // 5
    }
}
