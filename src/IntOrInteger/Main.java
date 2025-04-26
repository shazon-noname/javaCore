package src.IntOrInteger;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // Коди українських букв

        for (char lower = 'а', upper = 'А'; lower <= 'я'; lower++, upper++) {
            System.out.println(lower + " -> " + (int) lower + "\n" +
                    upper + " -> " + (int) upper );
        }

        System.out.println("\'" + " -> " + ((int) '\''));

    }
}

