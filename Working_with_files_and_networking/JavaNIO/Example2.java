package Working_with_files_and_networking.JavaNIO;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Example2 {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(16); // mark = -1, position = 0, limit = 16, capacity = 16
        buff.put("He".getBytes()); // mark = -1, position = 2, limit = 16, capacity = 16
        buff.mark(); // mark = 2, position = 2, limit = 16, capacity = 16
        buff.put("llo".getBytes()); // mark = 2, position = 5, limit = 16, capacity = 16
        buff.limit(8); // mark = 2, position = 5, limit = 8, capacity = 16

        //Метод duplicate() створить новий екземпляр ByteBuffer, який посилатиметься на ту саму ділянку пам'яті,
        // але матиме свої індекси, скопійовані з батьківського екземпляра.
        // Зміни даних відображатимуться одразу у двох екземплярах.
        ByteBuffer duplicateView = buff.duplicate(); // mark = 2, position = 5, limit = 8, capacity = 16
        duplicateView.position(0); // mark = 2, position = 0, limit = 8, capacity = 16
        duplicateView.put("Good day".getBytes()); // mark = 2, position = 8, limit = 8, capacity = 16
        System.out.println(new String(buff.array(), StandardCharsets.UTF_8)); // Good day

//      Метод slice() створить новий екземпляр ByteBuffer, починаючи з позиції, зазначеної в батьківському екземплярі,
//      скине індекси mark і position, а також встановить limit і capacity рівними розміру нового буфера.
        duplicateView.limit(16).put(" fellow".getBytes()); // mark = 2, position = 15, limit = 16, capacity = 16
        duplicateView.position(9).limit(15); // mark = 2, position = 9, limit = 15, capacity = 16
        ByteBuffer slicedView = duplicateView.slice(); // mark = -1, position = 0, limit = 7, capacity = 7
        byte [] slicedByteArr = new byte[slicedView.capacity()]; // створюємо масив байтів розміром із ємністю slicedView
        slicedView.get(slicedByteArr); // передаємо дані, починаючи з позиції 0
        System.out.println(new String(slicedByteArr, StandardCharsets.UTF_8)); // fellow

        byte[] bytes1 = "Ukrainian".getBytes();
        byte[] bytes2 = "HelloUkrainan".getBytes();

        ByteBuffer buffer1 = ByteBuffer.wrap(bytes1);
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes2);
        buffer2.position(5);
        // Порівнюватимуться байти від position до limit у кожному буфері,
        // якщо position або limit зміниться в одному з буферів, equals поверне false, а compareTo не дорівнюватиме нулю.
        boolean equal = buffer1.equals(buffer2); // true
        int result = buffer1.compareTo(buffer2); // 0
    }
}
