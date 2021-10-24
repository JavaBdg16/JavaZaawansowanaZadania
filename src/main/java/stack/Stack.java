package stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> implements Stackable<T> {

    private final int maxSize;

    private final List<T> elements;

    public Stack(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("Stack size must not be less than 0");
        }
        this.maxSize = maxSize;
        elements = new ArrayList<>();
    }

    public Stack() {
        this(Integer.MAX_VALUE);
    }

    @Override
    public void add(T element) throws StackMaxSizeException, StackDuplicateElementException {
        if (elements.size() == maxSize) {
            throw new StackMaxSizeException();
        }

        if (elements.contains(element)) {
            throw new StackDuplicateElementException();
        }

        elements.add(element);
    }

    @Override
    public T pop() throws EmptyStackException {
        T element = peek();
        elements.remove(element);

        return element;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (elements.size() == 0) {
            throw new EmptyStackException();
        }

        T element = elements.get(elements.size() - 1);

        return element;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
