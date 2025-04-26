package src.ExceptionHandling.example1;

public class InncorrectFileNameException extends RuntimeException{
    public InncorrectFileNameException() {
        super();
    }

    public InncorrectFileNameException(String message) {
        super(message);
    }
}
