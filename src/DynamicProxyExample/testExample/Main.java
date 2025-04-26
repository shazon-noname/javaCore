package src.DynamicProxyExample.testExample;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(25);
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?>[] interfaces = car.getClass().getInterfaces();
        CarStructure carStructure = (CarStructure) Proxy.newProxyInstance(classLoader,interfaces,new MyProxy(car));
        System.out.println(carStructure.displaySpeed());
        carStructure.increaseSpeed(25);
        System.out.println(carStructure.displaySpeed());
        carStructure.increaseSpeed(52);
        System.out.println(carStructure.displaySpeed());
    }
}
