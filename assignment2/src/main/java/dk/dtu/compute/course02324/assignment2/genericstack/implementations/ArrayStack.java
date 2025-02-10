package dk.dtu.compute.course02324.assignment2.genericstack.implementations;

import dk.dtu.compute.course02324.assignment2.genericstack.types.Stack;

import java.lang.reflect.Array;

/**
 * Implements a {@link Stack} of integers by using a sufficiently large
 * array. Note that the array is dynamically extended by copying it to
 * a larger array, whenever the stack size exceeds the current length
 * of the array.
 *
 * @param <E> the type of the values/elements on the stack
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * Constant defining the default size of the array when the
     * stack is created. The value can be any (strictly) positive
     * number. Here, we have chosen <code>10</code>, which is also
     * Java's default for some array-based collection implementations.
     */
    final private int DEFAULT_SIZE = 10;

    /**
     * The array in which the elements of the stack are stored.
     * The top of the stack is towards the higher numbers.
     *
     * NB: there is no really nice and elegant way to create
     *     a new instance of an array of a generic type like
     *        new E[DEFAULT_SIZE]
     *     in Java; the below is the nicest we can get and OK
     *     in our context: as long as it is just used internally
     *     in this class (the array as a whole is never returned
     *     to a client). In the long run (see later lectures and
     *     assignments, we recommend to Java's built-in lists
     *     anyway).
     */
    private E[] array = (E[]) new Object[DEFAULT_SIZE];

    /**
     * The current size of the stack. Note that the top-level
     * element is located at <code>size-1</code> in this array.
     */
    private int size = 0;

    @Override
    public void clear() {
        // TODO must be implemented
        array = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public E pop() throws IllegalStateException {
        // TODO must be implemented
        if (size != 0) {
            E element = array[size - 1];
            array[size - 1] = null;
            size--;
            if (size < array.length/2 && size >= DEFAULT_SIZE-1) {
                E[] newArray = (E[]) new Object[array.length/2];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }
            return element;
        }
        throw new IllegalStateException(
                "Cannot pop from empty stack"
        );
    }

    @Override
    public E top() {
        // TODO must be implemented
        if (size != 0) {
            return array[size - 1];
        }
        throw new IllegalStateException("Cannot check top on an empty stack");
    }

    @Override
    public void push(E value) {
        // TODO must be implemented
        if (value == null) {
            throw new IllegalArgumentException("Cannot Push null value");
        }
        if (size == array.length) {
            E[] newArray = (E[]) new Object[size*2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    @Override
    public int size() {
        // TODO must be implemented
        return size;
    }

}
