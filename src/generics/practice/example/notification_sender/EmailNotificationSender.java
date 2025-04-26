package src.generics.practice.example.notification_sender;

import src.generics.practice.example.notification.EmailNotification;

import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    @Override
    public void send(EmailNotification notification) {
        System.out.println("Email");
        System.out.println("Subject " + notification.getSubject());
        System.out.println("Receivers " + String.join(",", notification.getReceivers()));
        System.out.println("Message " + notification.getFormattedMessage());
    }

    @Override
    public void send(List<EmailNotification> notifications) {
        for (EmailNotification notification : notifications) {
            send(notification);
        }
    }
}
