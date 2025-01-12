package Collections.HashMap;

import java.util.*;
import java.util.regex.Pattern;

public class PhoneBook {

    private final Map<String, Set<String>> phoneBook = new TreeMap<>();
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{10,15}");
    private static final Pattern NAME_PATTERN = Pattern.compile("[А-Яа-яA-Za-z]+");

    public void addContact(String name, String phone) {
        phoneBook.putIfAbsent(name, new TreeSet<>());
        phoneBook.get(name).add(phone);
    }

    public Set<String> getPhonesByName(String name) {
        return phoneBook.getOrDefault(name, Collections.emptySet());
    }

    public String listContacts() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(String.join(", ", entry.getValue())).append("\n");
        }

        return sb.toString().trim();
    }

    public String getNameByPhone() {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    public boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook contactsPhoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введіть номер, ім'я або команду LIST");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("LIST")) {
                System.out.println(contactsPhoneBook.listContacts());
            } else if (contactsPhoneBook.isValidPhone(input)) {
                String name = contactsPhoneBook.getNameByPhone();
                if (name == null) {
                    System.out.println("Такого номеру немає в телефоні книзі");
                    System.out.println("Введіть номер абонента для імені \" " + input + "\": ");
                    String newName = scanner.nextLine().trim();
                    if (contactsPhoneBook.isValidName(newName)) {
                        contactsPhoneBook.addContact(newName, input);
                        System.out.println("Контакт збережено!");
                    } else {
                        System.out.println("Невірний формат!");
                    }
                } else {
                    System.out.println("Цей номер належить: " + name);
                }
            } else if (contactsPhoneBook.isValidName(input)) {
                Set<String> phones = contactsPhoneBook.getPhonesByName(input);
                if (phones.isEmpty()) {
                    System.out.println("Такого імені в телефонній книзі не існує");
                    System.out.print("Введіть ім'я абонента для номеру \"" + input + "\": ");
                    String phone = scanner.nextLine();
                    if (contactsPhoneBook.isValidPhone(phone)) {
                        contactsPhoneBook.addContact(input, phone);
                        System.out.println("Контакт збережено");
                    } else {
                        System.out.println("Невірний формат");
                    }
                } else {
                    System.out.println(input + " - " + String.join(", ", phones));
                }
            } else {
                System.out.println("Невірний формат вводу");
            }
        }
    }
}
