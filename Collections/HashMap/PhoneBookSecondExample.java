package Collections.HashMap;

import java.util.*;

public class PhoneBookSecondExample {
    private static final String PHONE_PATTERN = "\\d{10,15}";
    private static final String NAME_PATTERN = "[А-Яа-яA-Za-z]+";

    private final Map<String, Set<String>> nameToPhones = new TreeMap<>(); //Сортування по номеру
    private final Map<String, String> phoneToName = new HashMap<>(); // пошук по номеру телефона

    public void addContactByName(String name, String phone) {
        nameToPhones.putIfAbsent(name, new HashSet<>());
        nameToPhones.get(name).add(phone);
        phoneToName.put(phone, name);
    }

    public String listContacts() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Set<String>> entry : nameToPhones.entrySet()) {
            result.append(entry.getKey()).append(" - ").append(String.join(", ", entry.getValue())).append("\n");
        }
        return result.toString().trim();
    }

    public void addContactByPhone(String phone, String name) {
        addContactByName(name, phone);
    }

    public String getNameByPhone(String phone) {
        return phoneToName.get(phone);
    }

    public Set<String> getPhonesToName(String name) {
        return nameToPhones.getOrDefault(name, new HashSet<>());
    }

    public boolean isValidPhone(String phone) {
        return phone.matches(PHONE_PATTERN);
    }

    public boolean isValidName(String name) {
        return name.matches(NAME_PATTERN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBookSecondExample phoneBookSecondExample = new PhoneBookSecondExample();

        while (true) {
            System.out.println("Введіть номер, ім'я або команду");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("LIST")) {
                System.out.println(phoneBookSecondExample.listContacts());
            } else if (phoneBookSecondExample.isValidPhone(input)) {
                String name = phoneBookSecondExample.getNameByPhone(input);
                if (name == null) {
                    System.out.println("Такого номеру немає в телефоні книзі!");
                    System.out.println("Введіть ім'я абонента для цього номеру");
                    name = scanner.nextLine().trim();
                    if (phoneBookSecondExample.isValidName(name)) {
                        phoneBookSecondExample.addContactByPhone(input, name);
                        System.out.println("Контакт Збережено!");
                    } else {
                        System.out.println("Невірний формат імені");
                    }
                } else {
                    System.out.println("Ім'я абонента : " + name);
                }
            } else if (phoneBookSecondExample.isValidName(input)) {
                Set<String> phones = phoneBookSecondExample.getPhonesToName(input);
                if (phones.isEmpty()) {
                    System.out.println("Такого імені немає в телефоні книзі");
                    System.out.println("Ведіть номер телефона для абонента \"" + input + "\": ");
                    String phone = scanner.nextLine();
                    if (phoneBookSecondExample.isValidPhone(phone)) {
                        phoneBookSecondExample.addContactByName(input, phone);
                        System.out.println("Контакт Збережено!");
                    } else {
                        System.out.println("Невірний формат телефона");
                    }
                } else {
                    System.out.println("Телефони : " + String.join(", ", phones));
                }
            } else {
                System.out.println("Невірний формат введення.");
            }
        }
    }
}
