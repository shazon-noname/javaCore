package generics.practice.example2;

import generics.practice.example2.NotifactionDelivery.CourierDelivery;
import generics.practice.example2.NotifactionDelivery.DigitalDelivery;
import generics.practice.example2.NotifactionDelivery.PostalDelivery;
import generics.practice.example2.NotifactionDeliverySender.CourierDeliveryService;
import generics.practice.example2.NotifactionDeliverySender.DigitalDeliveryService;
import generics.practice.example2.NotifactionDeliverySender.PostalDeliveryService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо екземпляри різних типів доставок
        CourierDelivery courier1 = new CourierDelivery("Олексій", "вул. Шевченка, 12", "+380501234567");
        DigitalDelivery digital1 = new DigitalDelivery("email@example.com", "file1.txt");
        PostalDelivery postal1 = new PostalDelivery("12345", "вул. Лесі Українки, 10");

        CourierDelivery courier2 = new CourierDelivery("Марія", "вул. Франка, 5", "+380931234567");
        DigitalDelivery digital2 = new DigitalDelivery("mail@example.com", "file2.pdf");
        PostalDelivery postal2 = new PostalDelivery("67890", "вул. Тараса Шевченка, 20");

        // Створюємо сервіси для обробки різних типів доставок
        CourierDeliveryService courierService = new CourierDeliveryService();
        DigitalDeliveryService digitalService = new DigitalDeliveryService();
        PostalDeliveryService postalService = new PostalDeliveryService();

        // Обробка однієї доставки для кожного типу
        System.out.println("Одиночна доставка кур'єром:");
        courierService.processDelivery(courier1);

        System.out.println("\nОдиночна цифрова доставка:");
        digitalService.processDelivery(digital1);

        System.out.println("\nОдиночна поштовая доставка:");
        postalService.processDelivery(postal1);

        // Обробка списку доставок
        System.out.println("\nСписок доставок кур'єром:");
        courierService.processDeliveries(List.of(courier1, courier2));

        System.out.println("\nСписок цифрових доставок:");
        digitalService.processDeliveries(List.of(digital1, digital2));

        System.out.println("\nСписок поштових доставок:");
        postalService.processDeliveries(List.of(postal1, postal2));
    }
}