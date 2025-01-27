package generics.practice.example2.NotifactionDeliverySender;

import generics.practice.example2.NotifactionDelivery.DigitalDelivery;

import java.util.List;

public class DigitalDeliveryService implements DeliveryService<DigitalDelivery> {
    @Override
    public void processDelivery(DigitalDelivery delivery) {
        System.out.println("DIGITAL DELIVERY");
        System.out.println(delivery.getDeliveryDetails());
    }

    @Override
    public void processDeliveries(List<DigitalDelivery> deliveries) {
        for (DigitalDelivery delivery : deliveries) {
            processDelivery(delivery);
        }
    }
}
