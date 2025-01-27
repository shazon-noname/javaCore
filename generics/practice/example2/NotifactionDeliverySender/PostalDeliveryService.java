package generics.practice.example2.NotifactionDeliverySender;

import generics.practice.example2.NotifactionDelivery.PostalDelivery;

import java.util.List;

public class PostalDeliveryService implements DeliveryService<PostalDelivery> {
    @Override
    public void processDelivery(PostalDelivery delivery) {
        System.out.println("POSTAL DELIVERY");
        System.out.println(delivery.getDeliveryDetails());
    }

    @Override
    public void processDeliveries(List<PostalDelivery> deliveries) {
        for (PostalDelivery delivery : deliveries) {
            processDelivery(delivery);
        }
    }
}
