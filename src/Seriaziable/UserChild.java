package src.Seriaziable;

import java.io.*;

public class UserChild extends User implements Externalizable {

    @Serial
    private static final long serialVersionUID = -45643562456L;
    int childLevel;


    @Override
    public String toString() {
        return "UserChild{" +
                "childLevel=" + childLevel +
                ", sword=" + sword +
                ", lifeLeve=" + lifeLevel +
                '}';
    }

    public int getChildLevel() {
        return childLevel;
    }

    public void setChildLevel(int childLevel) {
        this.childLevel = childLevel;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getSword());
        out.write(getLifeLevel());
        out.write(getChildLevel());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setSword((Sword) in.readObject());
        setLifeLevel(in.read());
        setChildLevel(in.read());
    }
}
