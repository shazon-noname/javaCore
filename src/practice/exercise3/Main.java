package src.practice.exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageTask taskManager = new ManageTask();

        while (true) {
            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add task");
            System.out.println("2. Show tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Delete task");
            System.out.println("5. Clear task list");
            System.out.println("6. Exit");
            System.out.print("Choose an action: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer after number input

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Enter task description: ");
                    String taskText = scanner.nextLine();
                    taskManager.addTask(new Task(taskText));
                    break;
                case 2:
                    // Display all tasks
                    taskManager.listTasks();
                    break;
                case 3:
                    // Mark a task as completed
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = scanner.nextInt() - 1;
                    if (completeIndex >= 0 && completeIndex < taskManager.getTasks().size()) {
                        taskManager.getTasks().get(completeIndex).markAsCompleted();
                        System.out.println("Task marked as completed.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;
                    case 4:
                        // Delete a task
                        System.out.print("Enter task number to delete: ");
                        int deleteIndex = scanner.nextInt() - 1;
                        if (deleteIndex >= 0 && deleteIndex < taskManager.getTasks().size()) {
                            taskManager.deleteTaskByIndex(deleteIndex);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;
                case 5:
                    // Clear all tasks
                    taskManager.clearTasks();
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }
}


class Task {
    private final String task;
    private boolean isCompleteTask;

    public Task(String task) {
        this.task = task;
        this.isCompleteTask = false;
    }

    public void markAsCompleted() {
        this.isCompleteTask = true;
    }

    @Override
    public String toString() {
        return isCompleteTask ? "[✓] " + task : "[ ] " + task;
    }

    public String getTask() {
        return task;
    }
}

class ManageTask {
    private List<Task> tasks;

    public ManageTask() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
            System.out.println("Task added.");
        } else {
            throw new IllegalArgumentException("Task cannot be null.");
        }
    }

    public void deleteTaskByIndex(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }


    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void clearTasks() {
        tasks.clear();
        System.out.println("All tasks are deleted.");
    }
}
