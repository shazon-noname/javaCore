package EncapsulationProject.example;

public class Main {
    public static void main(String[] args) {
        // Створення початкових габаритів
        Dimensions dimensions = new Dimensions(2.5, 1.5, 1.0);

        // Створення початкового вантажу
        Cargo cargo = new Cargo(dimensions, 15.0, "123 Main Street", true, "REG12345", true);

        System.out.println("Початковий вантаж:");
        System.out.println(cargo);

        // Створення копії з новою адресою доставки
        Cargo updatedAddressCargo = cargo.withDeliveryAddress("456 Another Street");
        System.out.println("\nВантаж із новою адресою:");
        System.out.println(updatedAddressCargo);

        // Створення копії з новими габаритами
        Dimensions newDimensions = dimensions.withDimensions(3.0, 2.0, 1.5);
        Cargo updatedDimensionsCargo = cargo.withDimensions(newDimensions);
        System.out.println("\nВантаж із новими габаритами:");
        System.out.println(updatedDimensionsCargo);

        // Створення копії з новою масою
        Cargo updatedWeightCargo = cargo.withWeight(20.0);
        System.out.println("\nВантаж із новою масою:");
        System.out.println(updatedWeightCargo);

        // Перевірка, що початковий об'єкт залишився незмінним
        System.out.println("\nПочатковий вантаж залишився незмінним:");
        System.out.println(cargo);
    }
}
