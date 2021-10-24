package stack;

public interface Stackable<T> {

    void add(T element) throws StackDuplicateElementException, StackMaxSizeException;

    T pop() throws EmptyStackException;

    T peek() throws EmptyStackException;

    boolean isEmpty();
}
