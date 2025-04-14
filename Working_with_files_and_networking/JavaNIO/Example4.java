package Working_with_files_and_networking.JavaNIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Example4 {
    public static void main(String[] args) {
        String text = "Hello Ukraine";
        Charset winCharset = Charset.forName("windows-1251");
        ByteBuffer byteBuffer = winCharset.encode(text);

        CharBuffer charBuffer = winCharset.decode(byteBuffer);
        String textFromChar = charBuffer.toString();
        System.out.println(textFromChar);
    }
}
