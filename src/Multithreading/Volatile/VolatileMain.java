package src.Multithreading.Volatile;

/*
The volatile keyword in Java is used to indicate that a variable's value can be modified by different threads
 */
public class VolatileMain {
    volatile static int i = 0;


    public static void main(String[] args) {
        new MyThreadReader().start();
        new MyThreadWriter().start();
    }

    static class MyThreadWriter extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class MyThreadReader extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) {
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}
