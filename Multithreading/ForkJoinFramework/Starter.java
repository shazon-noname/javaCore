package Multithreading.ForkJoinFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Starter {
    public static void main(String[] args)  {
        final int MAX = 16;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new Action(MAX));
        System.out.println("Finish");
    }
}

 class Action extends RecursiveAction {
    private int value;

     public Action(int value ) {
         this.value =value;
     }

     @Override
     protected void compute()  {
         if (value <= 4) {
             System.out.println("Hello before:" + Thread.currentThread().getId() + " = " + value);
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Hello after: " + Thread.currentThread().getId() + " = " + value);
         } else {
             Action m1 = new Action(value / 2);
             Action m2 = m1;
             invokeAll(m1,m2);
         }
     }
 }