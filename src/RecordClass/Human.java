package src.RecordClass;

import java.util.Objects;

public class Human {
    private final int birthYear;
    private final String name;
    private final String surName;
    private final String lastName;

    public Human(int birthYear, String name, String surName, String lastName) {
        this.birthYear = birthYear;
        this.name = name;
        this.surName = surName;
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthYear == human.birthYear && Objects.equals(name, human.name) && Objects.equals(surName, human.surName) && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthYear, name, surName, lastName);
    }

    @Override
    public String toString() {
        return "Human{" +
                "birthYear=" + birthYear +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
