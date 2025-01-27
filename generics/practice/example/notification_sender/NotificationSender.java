package generics.practice.example.notification_sender;

import generics.practice.example.notification.Notification;

import java.util.List;

public interface NotificationSender<T extends Notification> {
    void send(T notification);
    void send(List<T> notifications);
}
