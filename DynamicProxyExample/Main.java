package DynamicProxyExample;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Man ivan = new Man("Іван", "Таллагассі", "США", 25);
        ClassLoader personClassLoader = ivan.getClass().getClassLoader();
        Class[] interfaces = ivan.getClass().getInterfaces();
        Person person = (Person) Proxy.newProxyInstance(personClassLoader,interfaces,new PersonInvocationHandler(ivan));

        person.introduce(ivan.getName());
        person.sayFrom(ivan.getCity(), ivan.getCountry());
        person.sayAge(ivan.getAge());
    }
}
