package Seriaziable;

import java.io.Serial;
import java.io.Serializable;

public class User {
// Static fields don`t serializable

    protected Sword sword;

    static int staticField;

    protected int lifeLevel;

    public int getLifeLevel() {
        return lifeLevel;
    }

    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }


    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }
    // transient when we don't want to serialize and returns a standard value
}

