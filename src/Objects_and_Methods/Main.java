package src.Objects_and_Methods;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");

        System.out.println();

        Processor processor = new Processor(4.25, 12, "AMD", 0.6 );
        Ram ram = new Ram("DDR4", 16, 0.1);
        Storage storage = new Storage("SSD", 468, 0.2);
        Screen screen = new Screen(24, "TN", 5);
        Keyboard keyboard = new Keyboard("mechanical",true, 1);

        Computer computer = new Computer("Dell", "Inspiron 15",processor,ram, storage, screen, keyboard);
        System.out.println(computer);

        Processor newProcessor = new Processor(4.2, 8, "AMD", 0.35);
        computer.setProcessor(newProcessor);

        Ram newRam = new Ram("DDR5", 32, 0.12);
        computer.setRam(newRam);

        System.out.println("\nAfter upgrading components:");
        System.out.println(computer);
    }
}