package src.Working_with_files_and_networking.JavaNIO;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Example {
    public static void main(String[] args) {
//        testMethod2();
//        testMethod();
        testMethod2Second();

//        ByteBuffer buff = ByteBuffer.allocate(20);
//
//        // Запис у буфер
//        buff.put((byte) 'H'); // position = 1, одиночний запис
//        // буфер: ['H', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//        buff.put("ello world".getBytes()); // position = 11, запис масиву байт
//        // буфер: ['H','e','l','l','o',' ','w','o','r','l','d',0,0,0,0,0,0,0,0,0]
//        buff.put(6, "Ukrainian".getBytes()); // запис з індексу 6, position не змінюється
//        // буфер: ['H','e','l','l','o',' ','U','k','r','a','i','n','i','a','n',0,0,0,0,0]
//
//        // Читання з буфера
//        buff.flip(); // position = 0, limit = 15 (останній записаний байт + 1)
//        char h = (char) buff.get(); // position = 1, зчитує 'H'
//        char e = (char) buff.get(); // position = 2, зчитує 'e'
//        char u = (char) buff.get(6); // зчитує 'U' з індексу 6, position залишається 2
//        char k = (char) buff.get(7); // зчитує 'k' з індексу 7, position залишається 2
//
//        byte[] hello = new byte[5];
//        buff.get(0, hello); // копіює 5 байт з індексу 0 у масив hello
//        String result = new String(hello, StandardCharsets.UTF_8);
//        System.out.println(result); // Виведе "Hello"
//
//        char x = (char) buff.get(14); // Спроба зчитати останній символ 'n' за межами limit = 11
//        System.out.println("Останній символ: " + x);
    }

    public static void testMethod() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);

        byteBuffer.put((byte) 'H');
        byteBuffer.put("ello world".getBytes());

        byteBuffer.position(6);
        byteBuffer.limit(11);

        byte[] string = new byte[byteBuffer.remaining()];
        byteBuffer.get(string);

        System.out.println(new String(string, StandardCharsets.UTF_8));
    }

    public static void testMethod2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        byteBuffer.put("david ".getBytes());
        byteBuffer.mark();
        byteBuffer.put("- gameruiner".getBytes());

        byteBuffer.flip();

        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        ByteBuffer duplicateView = byteBuffer.duplicate();
        duplicateView.position(6);
        duplicateView.put("- krutiy chuvak!".getBytes());

        byteBuffer.position(duplicateView.position());
        byteBuffer.flip();

        bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    public static void testMethod2Second() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        byteBuffer.put("david ".getBytes());
        byteBuffer.mark();
        byteBuffer.put("- gameruiner".getBytes());

        ByteBuffer duplicateView = byteBuffer.duplicate();

        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        duplicateView.reset();
        duplicateView.put("krutiy chuvak!".getBytes());

        duplicateView.flip();
        bytes = new byte[duplicateView.remaining()];
        duplicateView.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        duplicateView.position(0);
        duplicateView.limit(20);

        ByteBuffer slice = duplicateView.slice();
        slice.position(6).put("12k mmr!".getBytes()).flip();
        byte[] sliceByte = new byte[slice.remaining()];
        slice.get(sliceByte);
        System.out.println(new String(sliceByte, StandardCharsets.UTF_8));

        byteBuffer.position("david".getBytes().length);
        byteBuffer.put(" go v flatOut2".getBytes());

        byteBuffer.flip();

        bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}