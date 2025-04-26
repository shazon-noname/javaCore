package src.Optional;

import lombok.Getter;

@Getter
public class Computer {
    private final SoundCard soundCard;

    public Computer(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

}
