package TransferByReferenceOrByValue;

public class Order {
    public Product addProduct(Product p) {
        if (p.getPrice() > 999) {
            return p.setPrice(p.getPrice() - 200);
        }
        return p;
    }
}
