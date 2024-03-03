package Seriaziable;

import java.io.Serializable;

public class UserChild extends User implements Serializable {
    int childLevel;

    @Override
    public String toString() {
        return "UserChild{" +
                "childLevel=" + childLevel +
                ", lifeLevel=" + lifeLevel +
                ", sword=" + sword +
                '}';
    }
}
