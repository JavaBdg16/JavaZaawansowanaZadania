package stack;

public class StackDuplicateElementException extends Exception {
    public StackDuplicateElementException() {
    }

    public StackDuplicateElementException(String message) {
        super(message);
    }

    public StackDuplicateElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
