package RecordClass;

public record HumanRecord(int birthYear,
                          String name,
                          String surName,
                          String lastName) {

    public HumanRecord {
        System.out.println("hello from record!");
    }

    public void getInfo() {
        System.out.println(name + " " + lastName);
    }
}
