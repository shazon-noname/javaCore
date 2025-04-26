package src.generics.practice.example.notification_sender;

import src.generics.practice.example.notification.PushNotification;

import java.util.List;


public class PushNotificationSender implements NotificationSender<PushNotification>{
    @Override
    public void send(PushNotification notification) {
        System.out.println("PUSH");
        System.out.println("Title " + notification.getTitle());
        System.out.println("Receiver " + notification.getAccount());
        System.out.println("Message " + notification.getFormattedMessage());
    }

    @Override
    public void send(List<PushNotification> notifications) {
        for (PushNotification notification : notifications) {
            send(notification);
        }
    }
}
