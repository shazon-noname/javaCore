package StringPool;

public class Main {
    public static void main(String[] args) {
        String name1 = "Marian";
        String name2 = new String("Marian").intern();
        System.out.println(name1 == name2);
    }
}
