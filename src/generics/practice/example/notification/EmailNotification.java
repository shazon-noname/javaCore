package src.generics.practice.example.notification;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotification implements Notification {
    private String subject;
    private String message;
    private List<String> receivers;


    @Override
    public String getFormattedMessage() {
        return "<p>" + message + "</p>";
    }
}
