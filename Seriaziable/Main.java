package Seriaziable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserChild user = new UserChild();
        user.lifeLevel = 55;
        user.staticField = 45;
        user.sword = new Sword();
        user.sword.level = 5;
        user.childLevel = 65;



        FileOutputStream fileOutputStream = new FileOutputStream("tempfile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        user.staticField = 35; // Static fields don't serializable

        FileInputStream fileInputStream = new FileInputStream("tempfile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UserChild newUser = (UserChild) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(newUser.lifeLevel);
        System.out.println(newUser.staticField);
//        System.out.println(newUser.sword.level);
        System.out.println(newUser.sword);
        System.out.println(newUser.childLevel);
    }
}
