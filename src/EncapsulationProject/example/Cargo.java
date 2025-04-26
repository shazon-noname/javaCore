package src.EncapsulationProject.example;

public final class Cargo {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean canBeFlipped;
    private final String registrationNumber;
    private final boolean isFragile;

    public Cargo(Dimensions dimensions, double weight, String deliveryAddress, boolean canBeFlipped, String registrationNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.canBeFlipped = canBeFlipped;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isCanBeFlipped() {
        return canBeFlipped;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    // Метод для створення копії з новою адресою доставки
    public Cargo withDeliveryAddress(String newAddress) {
        return new Cargo(dimensions, weight, newAddress, canBeFlipped, registrationNumber, isFragile);
    }

    // Метод для створення копії з новими габаритами
    public Cargo withDimensions(Dimensions newDimensions) {
        return new Cargo(newDimensions, weight, deliveryAddress, canBeFlipped, registrationNumber, isFragile);
    }

    // Метод для створення копії з новою масою
    public Cargo withWeight(double newWeight) {
        return new Cargo(dimensions, newWeight, deliveryAddress, canBeFlipped, registrationNumber, isFragile);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "dimensions=" + dimensions +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", canBeFlipped=" + canBeFlipped +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", isFragile=" + isFragile +
                '}';
    }
}
