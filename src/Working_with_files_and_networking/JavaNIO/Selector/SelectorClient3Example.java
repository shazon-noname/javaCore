package src.Working_with_files_and_networking.JavaNIO.Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
public class SelectorClient3Example {
    public static void main(String[] args) throws IOException {
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("localhost", 8089));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть нове повідомлення для відправки на сервер: ");
            String message = scanner.nextLine();
            if ("exit".equals(message)) {
                break;
            }
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            clientChannel.write(buffer);
        }
        clientChannel.close();
    }
}