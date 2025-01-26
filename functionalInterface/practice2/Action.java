package functionalInterface.practice2;

public interface Action <T extends Number>{
    T calculate(T t1, T t2);
}
