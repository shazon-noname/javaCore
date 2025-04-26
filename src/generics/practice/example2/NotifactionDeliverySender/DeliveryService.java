package src.generics.practice.example2.NotifactionDeliverySender;

import src.generics.practice.example2.NotifactionDelivery.Delivery;

import java.util.List;

public interface DeliveryService< T extends Delivery> {
    void processDelivery(T delivery);
    void processDeliveries(List<T> deliveries);
}
