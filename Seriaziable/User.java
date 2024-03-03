package Seriaziable;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
// Static fields don`t serializable
    @Serial
    private static final long serialVersionUID = -45643562456L;
    int lifeLevel;
    static int staticField;

    // transient when we don't want to serialize and returns a standard value
    transient Sword sword;
}

