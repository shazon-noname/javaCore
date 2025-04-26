package src.generics.practice.example.notification_sender;

import src.generics.practice.example.notification.Notification;

import java.util.List;

public interface NotificationSender<T extends Notification> {
    void send(T notification);
    void send(List<T> notifications);
}
