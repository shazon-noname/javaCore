package generics.practice.example2.NotifactionDelivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DigitalDelivery implements Delivery{
    private String email;
    private String nameFile;

    @Override
    public String getDeliveryDetails() {
        return "Email: " + email +
                "\nFile name: " + nameFile;
    }
}
