package algos;

import java.util.function.Function;

public class Recursion {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                if (n == 1) {
                    return n;
                }
                return n * this.apply(n - 1);
            }
        };
        int result = factorial.apply(5);
        System.out.println(result);

        System.out.println(factorialMethod(5));

        System.out.println(fibonacciMethod(8));
    }

    public static int factorialMethod(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorialMethod(n - 1);
    }

    public static int fibonacciMethod(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciMethod(n - 1) + fibonacciMethod(n - 2);
    }
}

