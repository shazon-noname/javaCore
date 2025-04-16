package Working_with_files_and_networking.JavaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Example5 {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false); // Неблокуючий режим
        serverChannel.register(selector, SelectionKey.OP_ACCEPT); // Реєстрація події "прийняття"

        while (true) {
            selector.select(); // Очікування подій
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                if (key.isAcceptable()) {
                    // Приймаємо нове підключення
                    SocketChannel client = serverChannel.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ); // Тепер чекаємо читання
                    System.out.println("Підключився клієнт: " + client.getRemoteAddress());
                }

                if (key.isReadable()) {
                    // Читаємо дані від клієнта
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    int bytesRead = client.read(buffer);

                    if (bytesRead == -1) { // Клієнт відключився
                        client.close();
                    } else {
                        buffer.flip();
                        byte[] data = new byte[buffer.remaining()];
                        buffer.get(data);
                        System.out.println("Отримано: " + new String(data));
                    }
                }

                iter.remove(); // Видаляємо оброблений ключ
            }
        }
    }
}
