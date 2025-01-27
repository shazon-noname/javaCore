package Optional;

import java.util.Optional;

public class Computer {
    private final SoundCard soundCard;

    public Computer(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }
}
