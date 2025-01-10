package Collections.HashSet.exercise2;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class EmailList {
    private final TreeSet<String> emailSetList;
    private static final String EMAIL_REGEX = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public EmailList() {
        this.emailSetList = new TreeSet<>();
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public void add(String input) {
        try {
            if (emailSetList.contains(input)) {
                System.out.println("Адреса вже існує в списку");
            } else if (isValidEmail(input)) {
                emailSetList.add(input);
            } else {
                System.out.println("Введіть коректно електрону адресу");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void list() {
        if (!emailSetList.isEmpty()) {
            int count = 0;
            System.out.println(" - СПИСОК ЕЛЕКТРОНИХ АДРЕС -");
            for (String element : emailSetList) {
                System.out.println(++count + " - " + element);
            }
        } else {
            System.out.println("Список електроних адрес пустий!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            try {
                System.out.println("Введіть команду (ADD, LIST, EXIT):");
                String consoleInput = scanner.nextLine().trim();
                String[] parts = consoleInput.split(" ", 2);
                String command = parts[0].toUpperCase();

                switch (command) {
                    case "ADD":
                        emailList.add(parts[1]);
                        break;
                    case "LIST":
                        emailList.list();
                        break;
                    case "EXIT":
                        System.out.println("Вихід з програми");
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
