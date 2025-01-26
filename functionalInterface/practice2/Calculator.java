package functionalInterface.practice2;

public class Calculator {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        Action<Integer> actionSum = new Action<Integer>() {
            @Override
            public Integer calculate(Integer t1, Integer t2) {
                return t1 + t2;
            }
        };
        computation(a, b,actionSum);

        Action<Integer> subtract = new Action<Integer>() {
            @Override
            public Integer calculate(Integer t1, Integer t2) {
                return t1 - t2;
            }
        };
        computation(a,b,subtract);

        Action<Integer> divide = new Action<Integer>() {
            @Override
            public Integer calculate(Integer t1, Integer t2) {
                return t1 / t2;
            }
        };
        computation(a,b,divide);

        Action<Integer> multiply = new Action<Integer>() {
            @Override
            public Integer calculate(Integer t1, Integer t2) {
                return t1 * t2;
            }
        };
        computation(a,b,multiply);
    }

    private static void computation(int a, int b,Action<Integer> action) {
        int result = calculate(a, b,action);
        System.out.println( action.getClass() +  " = " + result);
    }

    private static int calculate (int a, int b, Action<Integer> action) {
        return action.calculate(a,b);
    }
}
