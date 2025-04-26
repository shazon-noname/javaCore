package src.RecordClass;

public class RecordExample {
    public static void main(String[] args) {
        Human human = new Human(1992, "Ivan", "Ivanovich", "Ivanov");
        System.out.println(human);
        HumanRecord secondHuman = new HumanRecord(1991, "Ivan", "Ivanovich", "Ivanov");
        System.out.println(secondHuman);
        secondHuman.getInfo();
    }
}
