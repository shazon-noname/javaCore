package src.CloneObjects;

public class CloneObjects {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyObject myObject = new MyObject();
        myObject.i = 1;
        NewObject newObject = new NewObject();
        newObject.j = 3;
        myObject.newObject = newObject;
        MyObject myObject1 = myObject.clone();
        System.out.println("myObject1.i = " + myObject1.i);
        myObject1.i = 2;
        System.out.println("myObject.i = " + myObject.i);
        System.out.println("myObject1.i = " + myObject1.i);
        myObject1.newObject.j = 4;
        System.out.println("myObject.j = " + myObject.newObject.j);
        System.out.println("myObject1.j = " + myObject1.newObject.j);
    }
}

class MyObject implements Cloneable {
    int i;
    NewObject newObject;

    @Override
    protected MyObject clone() throws CloneNotSupportedException {
        MyObject myObject = new MyObject();
        myObject.newObject = newObject.clone();
        return myObject;
    }
}

class NewObject implements Cloneable {
    int j;

    @Override
    protected NewObject clone() throws CloneNotSupportedException {
        return (NewObject) super.clone();
    }
}