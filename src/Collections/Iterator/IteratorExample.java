package src.Collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Red");
        arrayList.add("Purple");
        arrayList.add("Pink");
        arrayList.add("Orange");
        arrayList.add("Black");

        Iterator<String> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            String color = iterator.next();
            if (color.equals("Red")) {
                iterator.remove();
            }
        }

        System.out.println(arrayList);
    }
}
