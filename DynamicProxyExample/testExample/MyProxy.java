package DynamicProxyExample.testExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
    Car car;

    public MyProxy(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (car.getSpeed() == 25) {
            System.out.println("Швидкість становить 25, тому ми збільшимона на 25");
            car.increaseSpeed(25);
            System.out.println(car.displaySpeed());
        }

        return method.invoke(car, args);
    }
}
