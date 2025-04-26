package src.Collections.HashSet.exercise1;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Task> tasks =new TreeSet<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        tasks.add(new Task("Buy milk"));
        tasks.add(new Task("Buy milk"));
        tasks.add(new Task("Buy chocolate"));
        tasks.add(new Task("Buy chocolate"));
        tasks.add(new Task("Buy cheese"));
        tasks.add(new Task("Buy cheese"));

        for (Task task : tasks) {
            System.out.println(task);
        }

        System.out.println("\nceiling - " + tasks.ceiling(new Task("Buy milk")) + System.lineSeparator());

        System.out.println("pollLast() - " + tasks.pollLast() + System.lineSeparator());

        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
