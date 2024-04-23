package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        NumberPredicate predicate = a -> a.doubleValue() != 0;
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(0));

        //перетворення одного типу даних в інший
        Function<User, Student> userStudentFunction = user ->
            new Student(user.getName(), user.getSurname(), 1);
        System.out.println(userStudentFunction
                .apply(new User("Viktor","A.")));

        BiFunction<User,Integer, Student> userStudentBiFunction = (user, year) ->
                new Student(user.getName(), user.getSurname(), year);
        System.out.println(userStudentBiFunction
                .apply(new User("Viktor","A."), 5));
    }
}
