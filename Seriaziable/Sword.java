package Seriaziable;

import java.io.Serializable;

public class Sword implements Serializable {
    protected int level;

    @Override
    public String toString() {
        return "Sword{" +
                "level=" + level +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
