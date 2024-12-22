package TransferByReferenceOrByValue;

public class Product {
    private final String productName;
    private final int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        return new Product(productName, price);
    }
    public Product setProductName(String productName) {
        return new Product(productName, price);
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
