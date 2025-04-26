package src.Optional;

import lombok.Getter;

@Getter
public class USB {
    private final String version;

    public USB(String version) {
        this.version = version;
    }

}
