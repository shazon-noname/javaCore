package generics.practice.example.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PushNotification implements Notification{
    private String title;
    private String message;
    private String account;

    @Override
    public String getFormattedMessage() {
        return "\ud83d\udc4b " + message; // Emoji + text
    }
}
