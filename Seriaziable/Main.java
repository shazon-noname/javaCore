package Seriaziable;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialization();
        deserialization();
    }

    private static void serialization() throws IOException {
        UserChild user = new UserChild();
        user.lifeLevel = 55;
        user.staticField = 45;
        user.sword = new Sword();
        user.sword.level = 5;
        user.childLevel = 65;
        //        Static fields don't serializable

        FileOutputStream fileOutputStream = new FileOutputStream("tempfile.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
    }
    private static void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("tempfile.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UserChild newUser = (UserChild) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(newUser.toString());
    }
}
