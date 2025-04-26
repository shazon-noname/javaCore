package src;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        SomeClass someClass = new SomeClass();
        Class clss  = someClass.getClass();
//        Class clss2 = src.SomeClass.class;
//        Class clss3 = Class.forName("src.SomeClass");
//        src.SomeClass someClass1 = (src.SomeClass) clss.newInstance();
//        System.out.println(clss.getName());

        Constructor[] constructors = clss.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }
        System.out.println("");
        System.out.println("Methods");
        Method[] methods = clss.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());
        }

        System.out.println("");
        System.out.println("Fields");
        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            field.setAccessible(true);
            System.out.println(field.getInt(someClass));
            field.setInt(someClass,5);
            System.out.println(field.getInt(someClass));

        }

    }
}

class SomeClass {
    private int i;
//    String s;

    public SomeClass() {
    }

//    src.SomeClass(String s) {
//        this.s = s;
//    }

    public synchronized String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }

}