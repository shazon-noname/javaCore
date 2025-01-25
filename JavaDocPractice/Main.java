package JavaDocPractice;

// javadoc -d JavaDocPractice.docs JavaDocPractice/Calculator.java    -  generate html JavaDocPractice.docs

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(Calculator.OPERATIONS_COUNT);

        System.out.println(calculator.divide(5,10));
    }
}
