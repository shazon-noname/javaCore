package src.generics.practice.example2.NotifactionDelivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostalDelivery implements  Delivery{
    private String numberDelivery;
    private String address;

    @Override
    public String getDeliveryDetails() {
        return "Delivery number: " + numberDelivery +
                "\nAddress: " + address;
    }
}
