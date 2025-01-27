package generics.practice.example.notification_sender;

import generics.practice.example.notification.SmsNotification;

import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public void send(SmsNotification notification) {
        System.out.println("SMS");
        System.out.println("Receivers " + String.join(", ", notification.getPhoneNumbers()));
        System.out.println("Message " + notification.getFormattedMessage());
    }

    @Override
    public void send(List<SmsNotification> notifications) {
        for (SmsNotification notification : notifications) {
            send(notification);
        }
    }
}
