package src.JavaDocPractice;

// javadoc -d src.JavaDocPractice.docs src.JavaDocPractice/Calculator.java    -  generate html src.JavaDocPractice.docs

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(Calculator.OPERATIONS_COUNT);

        System.out.println(calculator.divide(5,10));
    }
}
