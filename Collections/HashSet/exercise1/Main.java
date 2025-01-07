package Collections.HashSet.exercise1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Task> tasks =new HashSet<>();
        tasks.add(new Task("Buy milk"));
        tasks.add(new Task("Buy milk"));
        tasks.add(new Task("Buy chocolate"));
        tasks.add(new Task("Buy chocolate"));
        tasks.add(new Task("Buy cheese"));
        tasks.add(new Task("Buy cheese"));

        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
