package TransferByReferenceOrByValue;

public class Order {
    public Product addProduct(Product p) throws CloneNotSupportedException {
        if (p.getPrice() > 999) {
            Product copy = p.clone();
            return copy.setPrice(p.getPrice() - 200);
        }
        return p;
    }
}
