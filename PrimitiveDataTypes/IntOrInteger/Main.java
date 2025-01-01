package PrimitiveDataTypes.IntOrInteger;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: нижче напишіть код для виконання завдання:
        //  За допомогою циклу і перетворення чисел у символи знайдіть усі коди
        //  літер українського алфавіту - великих і малих, зокрема апострофу.


        // Коди українських букв

        for (char lower = 'а', upper = 'А'; lower <= 'я'; lower++, upper++) {
            System.out.println(lower + " -> " + (int) lower + "\n" +
                    upper + " -> " + (int) upper );
        }

        System.out.println("\'" + " -> " + ((int) '\''));



    }
}

