package generics.practice.example2.NotifactionDelivery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class CourierDelivery implements Delivery {
    private String courierName;
    private String address;
    private String phoneNumber;

    private static final String PHONE_NUMBER_PATTERN = "^\\+380\\d{9}$";

    public CourierDelivery(String courierName, String address, String phoneNumber) {
        this.courierName = courierName;
        this.address = address;
        setPhoneNumber(phoneNumber);
    }

    @Override
    public String getDeliveryDetails() {
        return "Courier: " + courierName + "\nAddress: " + address + "\nPhone: " + phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Неверный формат номера телефона: " + phoneNumber);
        }
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
