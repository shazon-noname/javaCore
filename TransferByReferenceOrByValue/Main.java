package TransferByReferenceOrByValue;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("IPhone", 1000);
        Order order = new Order();
        product = order.addProduct(product);
        System.out.println(product.getProductName() + " " + product.getPrice());
    }
}
