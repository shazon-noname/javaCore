package functionalInterface.practice2;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class Calculator {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int resultSum = calculate(a, b, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer firstNumber, Integer secondNumber) {
                return firstNumber + secondNumber;
            }
        });
        System.out.println("resultSum = " + resultSum);

        int resultSubtract = calculate(a, b, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer firstNumber, Integer secondNumber) {
                return firstNumber - secondNumber;
            }
        });
        System.out.println("resultSubtract = " + resultSubtract);

        int resultMultiply = calculate(a, b, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer firstNumber, Integer secondNumber) {
                return firstNumber * secondNumber;
            }
        });
        System.out.println("resultMultiply = " + resultMultiply);

        int resultDivide = calculate(a, b, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer firstNumber, Integer secondNumber) {
                return firstNumber / secondNumber;
            }
        });
        System.out.println("resultDivide = " + resultDivide);


    }

    private static int calculate(int a, int b, BiFunction<Integer, Integer, Integer> action) {
        return action.apply(a, b);
    }
}
