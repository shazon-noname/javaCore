package TransferByReferenceOrByValue;

public class Order {
    public void addProduct(Product p) {
        if (p.getPrice() > 999) {
            p.setPrice(p.getPrice() - 200);
        }
    }
}
