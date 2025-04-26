package src.ExceptionHandling.example;

public class Main {
    public static void main(String[] args) {
        try {
            try (MyResource myResource = new MyResource()) {
                doSomething();
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e);
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println(throwable);
            }
        }
    }

    public static void doSomething() {
        int[] array = null;
        array[3] = 3;
    }
}
