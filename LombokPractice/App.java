package LombokPractice;

public class App {
    public static void main(String[] args) {
        Product product = new Product("BMW", 60_000);
        print(product);

        product.setName("AUDI");
        product.setPrice(50_000);

        System.out.println(product);
    }

    public static void print(Product product) {
        System.out.println("product name: " + product.getName() + "\nproduct price: " + product.getPrice());
    }
}
