package functionalInterface.practice2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Calculator {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int resultSum = calculate(a, b, (a1,b1)-> a1+b1);
        System.out.println("resultSum = " + resultSum);

        List<Integer> integerList = Arrays.asList(1,2,3,4);
        integerList.forEach(System.out::println);

        Consumer<String> consumer = string -> System.out.println(string);
        Consumer<String> consumer1 = System.out::println;
        Consumer<String> consumer3 = Calculator::print;

        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());

    }

    public static void print(String string) {
        System.out.println(string);
    }

    private static int calculate(int a, int b, BiFunction<Integer, Integer, Integer> action) {
        return action.apply(a, b);
    }
}
