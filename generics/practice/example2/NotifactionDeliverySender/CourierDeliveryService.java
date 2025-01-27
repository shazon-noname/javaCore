package generics.practice.example2.NotifactionDeliverySender;

import generics.practice.example2.NotifactionDelivery.CourierDelivery;

import java.util.List;

public class CourierDeliveryService implements DeliveryService<CourierDelivery> {
    @Override
    public void processDelivery(CourierDelivery delivery) {
        System.out.println("COURIER DELIVERY");
        System.out.println(delivery.getDeliveryDetails());
    }

    @Override
    public void processDeliveries(List<CourierDelivery> deliveries) {
        for (CourierDelivery delivery : deliveries) {
            processDelivery(delivery);
        }
    }
}


