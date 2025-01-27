package generics.practice.example2.NotifactionDelivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourierDelivery implements Delivery {
    private String courierName;
    private String address;
    private String phoneNumber;

    @Override
    public String getDeliveryDetails() {
        return "Courier: " + courierName + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }
}
