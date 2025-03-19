package LoggingExample.Example.Exceptions;

public class InvalidComponentsCountException extends RuntimeException {
    public InvalidComponentsCountException(String message) {
        super(message);
    }
}