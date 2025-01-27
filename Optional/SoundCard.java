package Optional;

public class SoundCard {
    private final USB usb;

    public SoundCard(USB usb) {
        this.usb = usb;
    }

    public USB getUsb() {
        return usb;
    }
}
