package src.DynamicProxyExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalTime;

public class PersonInvocationHandler implements InvocationHandler {
    Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null && args.length > 0) {
            System.out.println("Параметри: ");
            for (Object arg : args) {
                System.out.println("- " + arg);
            }
        }
        System.out.println("Час виклику " + LocalTime.now());

        Object result = method.invoke(person, args);

        System.out.println("Метод " + method.getName() + "виконав свою роботу!" + "\n");

        return result;
    }
}
