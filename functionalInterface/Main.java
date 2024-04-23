package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student("Nick", "N", 1),
                new Student("Alex", "A", 2),
                new Student("Mark", "M", 3)
        );

        Predicate<Student> studentPredicate = student -> student.getYearOfStudy() > 1;
        Function<Student, User> studentUserFunction = student ->
                new User(student.getName(), student.getSurname());

        List<User> users = new ArrayList<>();
        for (Student student : studentList) {
            if (studentPredicate.test(student)) {
                users.add(studentUserFunction.apply(student));
            }
        }
        System.out.println(users);
    }
}
