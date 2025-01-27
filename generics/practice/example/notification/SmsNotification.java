package generics.practice.example.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsNotification implements Notification{
    private String message;
    private List<String> phoneNumbers;

    @Override
    public String getFormattedMessage() {
        return message;
    }
}
