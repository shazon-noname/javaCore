package TransferByReferenceOrByValue;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Product a = new Product("IPhone", 1000);
        Product b = a;
        b.setProductName("Samsung");
        System.out.println(a.getProductName());
        
    }
}
