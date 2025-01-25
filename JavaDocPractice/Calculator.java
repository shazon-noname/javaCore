package JavaDocPractice;

/**
 * Calculate simple operations
 *
 * @author marian
 */

public class Calculator {
    /**
     * Total count of operations, that this Calculator can perform
     */
    public static final int OPERATIONS_COUNT = 4;

    /**
     * Performs division one number by another
     * @param a First value
     * @param b Second value
     * @return Division result
     * @throws ArithmeticException if an attempt is made to divide by zero
     */
    public double divide(double a, double b) throws ArithmeticException{
        if (b == 0 || a == 0) {
            throw new ArithmeticException("Division by zero is impossible or first number zero");
        }

        return a / b;


    }
}
