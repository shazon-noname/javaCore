package TransferByReferenceOrByValue;

public class Product  implements Cloneable {
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
    protected Product clone() throws CloneNotSupportedException {
        Product product = (Product) super.clone();
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
