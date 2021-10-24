package stack;

public class StackMaxSizeException extends Exception {
    public StackMaxSizeException() {
    }

    public StackMaxSizeException(String message) {
        super(message);
    }

    public StackMaxSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
