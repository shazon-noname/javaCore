package src.TransferByReferenceOrByValue;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product product = new Product("IPhone", 1000);
        Order order = new Order();
        Product copy = order.addProduct(product);
        System.out.println(product.getProductName() + " стандартна ціна = " + product.getPrice());
        System.out.println(copy.getProductName() + " ціна після скидки = " + copy.getPrice());
    }
}

