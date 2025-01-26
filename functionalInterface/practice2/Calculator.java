package functionalInterface.practice2;

public class Calculator {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        Action<Integer> actionSum = new ActionSum();
        computation(a, b,actionSum);

        Action<Integer> subtract = new ActionSubtract();
        computation(a,b,subtract);

        Action<Integer> divide = new ActionDivide();
        computation(a,b,divide);

        Action<Integer> multiply = new ActionMultiply();
        computation(a,b,multiply);
    }

    private static void computation(int a, int b,Action<Integer> action) {
        int result = calculate(a, b,action);
        System.out.println(action.getClass().getSimpleName() + " = " + result);
    }

    private static int calculate (int a, int b, Action<Integer> action) {
        return action.calculate(a,b);
    }
}
