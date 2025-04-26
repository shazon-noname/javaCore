package src.Optional;

import lombok.Getter;

@Getter
public class SoundCard {
    private final USB usb;

    public SoundCard(USB usb) {
        this.usb = usb;
    }

}
