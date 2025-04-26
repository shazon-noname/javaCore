package src.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private final List<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void ADD(String input) {
        String[] parts = input.split(" ", 2);
        try {
            if (parts.length == 2 && parts[0].matches("\\d+")) { // Якщо вказано індекс
                int index = Integer.parseInt(parts[0]);
                if (index >= 0 && index <= tasks.size()) {
                    tasks.add(index, parts[1]);
                    System.out.println("Додано справу \"" + parts[1] + "\" на позицію " + index);
                } else {
                    tasks.add(parts[1]);
                    System.out.println("Додано справу \"" + parts[1] + "\" в кінець списку");
                }
            } else { // Якщо індекс не вказано
                tasks.add(input);
                System.out.println("Додано справу \"" + input + "\"");
            }
        } catch (Exception e) {
            System.out.println("Помилка при додаванні справи: " + e.getMessage());
        }
    }

    public void LIST() {
        if (tasks.isEmpty()) {
            System.out.println("Список порожній!");
        } else {
            System.out.println("Список справ:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + " - " + tasks.get(i));
            }
        }
    }

    public void EDIT(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            String oldTask = tasks.set(index, newTask);
            System.out.println("Справу \"" + oldTask + "\" змінено на \"" + newTask + "\"");
        } else {
            System.out.println("Справи з таким номером не існує");
        }
    }

    public void DELETE(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Справу \"" + removedTask + "\" видалено");
        } else {
            System.out.println("Справи з таким номером не існує");
        }
    }

    public static void main() {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть команду (ADD, LIST, EDIT, DELETE):");
            String consoleInput = scanner.nextLine().trim();
            String[] parts = consoleInput.split(" ", 2);
            String command = parts[0].toUpperCase();
            try {
                switch (command) {
                    case "ADD":
                        if (parts.length > 1) {
                            todoList.ADD(parts[1]);
                        } else {
                            System.out.println("Введіть справу для додавання");
                        }
                        break;
                    case "LIST":
                        todoList.LIST();
                        break;
                    case "EDIT":
                        if (parts.length > 1) {
                            String[] editParts = parts[1].split(" ", 2);
                            if (editParts.length == 2 && editParts[0].matches("\\d+")) {
                                int index = Integer.parseInt(editParts[0]);
                                todoList.EDIT(index, editParts[1]);
                            } else {
                                System.out.println("Введіть коректний індекс та нову справу");
                            }
                        } else {
                            System.out.println("Введіть індекс та нову справу");
                        }
                        break;
                    case "DELETE":
                        if (parts.length > 1 && parts[1].matches("\\d+")) {
                            int index = Integer.parseInt(parts[1]);
                            todoList.DELETE(index);
                        } else {
                            System.out.println("Введіть коректний індекс для видалення");
                        }
                        break;
                    case "EXIT":
                        System.out.println("Вихід з програми");
                        return;
                    default:
                        System.out.println("Невідома команда. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }
}
