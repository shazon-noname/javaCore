package src.generics.practice.example;

import src.generics.practice.example.notification.EmailNotification;
import src.generics.practice.example.notification.PushNotification;
import src.generics.practice.example.notification.SmsNotification;
import src.generics.practice.example.notification_sender.EmailNotificationSender;
import src.generics.practice.example.notification_sender.PushNotificationSender;
import src.generics.practice.example.notification_sender.SmsNotificationSender;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення сповіщень
        EmailNotification email1 = new EmailNotification("Реєстрація", "Дякуємо за реєстрацію!", List.of("user1@mail.com"));
        SmsNotification sms1 = new SmsNotification("Дякуємо за реєстрацію!", List.of("+380001234567"));
        PushNotification push1 = new PushNotification("Реєстрація", "Дякуємо за реєстрацію!", "userAccount");

        // Сервіси для відправлення
        EmailNotificationSender emailSender = new EmailNotificationSender();
        SmsNotificationSender smsSender = new SmsNotificationSender();
        PushNotificationSender pushSender = new PushNotificationSender();

        // Відправлення
        emailSender.send(email1);
        System.out.println();

        smsSender.send(sms1);
        System.out.println();

        pushSender.send(push1);
    }
}
