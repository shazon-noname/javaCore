package Objects_and_Methods;

public class Computer {
    String vendor;
    String name;
    Processor processor;
    Ram ram;
    Storage storage;
    Screen screen ;
    Keyboard keyboard;

    public Computer(String vendor, String name, Processor processor, Ram ram, Storage storage, Objects_and_Methods.Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
        System.out.println("Initial computer configuration");

    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Screen getScreen() {
        return Screen;
    }

    public void setScreen(Screen screen) {
        Screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor=" + processor +
                ", ram=" + ram +
                ", storage=" + storage +
                ", Screen=" + Screen +
                ", keyboard=" + keyboard +
                '}';
    }
}



final class  Processor {
    private double frequency;
    private int threads;
    private String manufacturer;
    private double weight;

    Processor(double frequency, int threads, String manufacturer, double weight) {
        this.frequency = frequency;
        this.threads = threads;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "frequency=" + frequency +
                ", threads=" + threads +
                ", manufacturer='" + manufacturer + '\'' +
                ", weight=" + weight +
                '}';
    }
}

final class Ram {
    private String type;
    private int size;
    private double weight;

    public Ram(String type, int size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "type='" + type + '\'' +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}

final class Storage {
    private String type;
    private int capacity;
    private double weight;

    public Storage(String type, int capacity, double weight) {
        this.type = type;
        this.capacity = capacity;
        this.weight = weight;


    }

    @Override
    public String toString() {
        return "Storage{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                ", weight=" + weight +
                '}';
    }
}

final class Screen  {
    private double diagonal;
    private String type;
    private double weight;

    public Screen(double diagonal, String type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "diagonal=" + diagonal +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}

final class Keyboard {
    private String type;
    private boolean backlit;
    private double weight;

    public Keyboard(String type, boolean backlit, double weight) {
        this.type = type;
        this.backlit = backlit;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "type='" + type + '\'' +
                ", backlit=" + backlit +
                ", weight=" + weight +
                '}';
    }
}
