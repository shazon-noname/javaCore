package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//Producer Extends, Consumer Super
public class Pecs {
    public static void main(String[] args) {
        Phone phone = new Phone("Iphone 15");
        Phone phone1 = new Phone("Samsung s24");
        Phone phone2 = new Phone("Iphone 15 pro max");
        Phone phone3 = new Phone("Google pixel 7");

        // Change the type to List<Product>
        ArrayList<Product> list = new ArrayList<>(Arrays.asList(phone, phone1, phone2, phone3));
        ArrayList<Product> copyList = new ArrayList<>();
        Product product = new Product();
        product.copy(list, copyList);

        for (Product o : copyList) {
            if (o instanceof Phone phone4) {
                System.out.println(phone4);
            } else {
                System.out.println("its not Phone!!!");
            }
        }

//        System.out.println(copyList.toString());
    }

}


class Product {
    public void copy(List<? extends Product> src, List<? super Product> dest) {
        dest.addAll(src);
    }
}

class Phone extends Product {
    String model;

    @Override
    public String toString() {
        return String.valueOf(model);
    }

    public Phone(String model) {
        this.model = model;
    }
}
