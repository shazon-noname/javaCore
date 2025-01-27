package LombokPractice;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
//@EqualsAndHashCode

// @Value - це незмінний варіант @Data. З цією
// анотацією Lombok за замовчуванням робить усі поля
// private і final. Крім того, сеттери не генеруються,
// а клас як такий позначається final.
// Таким чином, від цього класу не можна успадковувати.
// Так само, як і у випадку з @Data, створюються реалізації
// toString(), equals() і hashCode()

@Data
//@Data - це скорочена анотація, що поєднує
//можливості @ToString, @EqualsAndHashCode, @Getter
//@Setter і @RequiredArgsConstructor.
public class Product {
    //    @ToString.Include
    private String name;
    //    @ToString.Exclude
    private int price;


    // @NonNull - згенерує код для перевірки значення на null, в цьому випадку String name;
    public Product(@NonNull String name, int price) {
        this.name = name;
        this.price = price;
    }

}


