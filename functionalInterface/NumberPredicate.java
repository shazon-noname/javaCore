package functionalInterface;

import java.util.function.Predicate;
@FunctionalInterface
public interface NumberPredicate extends Predicate<Number> {
    boolean test(Number number);
}