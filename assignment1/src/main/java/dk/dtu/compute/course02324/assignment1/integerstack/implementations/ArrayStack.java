package dk.dtu.compute.course02324.assignment1.integerstack.implementations;

import dk.dtu.compute.course02324.assignment1.integerstack.types.Stack;

/**
 * Implements a {@link Stack} of integers by using a sufficiently large
 * array. Note that the array needs to be dynamically extended by
 * copying it to a larger array, whenever the stack size exceeds the
 * current length of the array.
 *
 * TODO note that this is template only, and the actual functions of
 *       the stack are not implemented yet. Implementing these methods
 *       is the task of assignment 1.
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 */
public class ArrayStack implements Stack {

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
     * TODO note that arrays in Java have fixed size! So the
     *      this array will need to be changed at runtime,
     *      when need should be!
     */
    private Integer[] array = new Integer[DEFAULT_SIZE];

    /**
     * The current size of the stack. Note that the top-level
     * element should be located at <code>size-1</code> in this array.
     */
    private int size = 0;

    @Override
    public void clear() {
        // TODO must be implemented
        array = new Integer[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public Integer pop() {
        // TODO must be implemented
        if (size!=0) {
            int element = array[size - 1];
            array[size - 1] = null;
            size--;
            if (size < array.length/2 && size >= DEFAULT_SIZE-1) {
                Integer[] newArray = new Integer[array.length/2];
                for (int i = 0; i < size ; i++) {
                    newArray[i] = array[i];
                }
                // System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }
            return element;
        }
        return null;
    }

    @Override
    public Integer top() {
        // TODO must be implemented
        if (size!=0){
            return array[size-1];
        }
        return null;
    }

    @Override
    public void push(Integer value) {
        // TODO must be implemented
        if (size==array.length){
            Integer[] newArray = new Integer[size * 2];
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

package dk.dtu.compute.course02324.assignment3.lists.implementations;



import dk.dtu.compute.course02324.assignment3.lists.types.List;

import javax.validation.constraints.NotNull;
import java.util.Comparator;

/**
 * An implementation of the interface {@link List} based on basic Java
 * arrays, which dynamically are adapted in size when needed.
 *
 * @param <E> the type of the list's elements.
 */
public class ArrayList<E> implements List<E> {

    /**
     * Constant defining the default size of the array when the
     * list is created. The value can be any (strictly) positive
     * number. Here, we have chosen <code>10</code>, which is also
     * Java's default for some array-based collection implementations.
     */
    final private int DEFAULT_SIZE = 10;

    /**
     * Current size of the list.
     */
    private int size = 0;

    /**
     *  The array for storing the elements of the
     */
    private E[] list = createEmptyArray(DEFAULT_SIZE);

    @Override
    public void clear() {
        list = createEmptyArray(DEFAULT_SIZE);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public @NotNull E get(int pos) throws IndexOutOfBoundsException {
        if (pos>=size or pos<0) {
            throw new IndexOutOfBoundsException("Not within bounds");
        }
        return list[pos-1];
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public E set(int pos, @NotNull E e) throws IndexOutOfBoundsException {
        if (pos>=size or pos<0) {
            throw new IndexOutOfBoundsException("Not within bounds");
        }
        if (size==list.length){ doubleList();}
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public boolean add(@NotNull E e) {
        if (size==list.length){ doubleList();}
        list[size] = value;
        size++;
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public boolean add(int pos, @NotNull E e) throws IndexOutOfBoundsException {
        if (pos>=size or pos<0) {
            throw new IndexOutOfBoundsException("Not within bounds");
        }
        if (size==list.length){ doubleList();}
        throw new UnsupportedOperationException("This operation is not yet implemented!");
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public E remove(int pos) throws IndexOutOfBoundsException {
        if (size < list.length/2) { halveList();}
        throw new UnsupportedOperationException("This operation is not yet implemented!");
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public boolean remove(E e) {
        if (size < list.length/2) { halveList();}
        throw new UnsupportedOperationException("This operation is not yet implemented!");
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i<size; i++) {
            if (list[i] == e) {
                return i;
            }
        }
        return -1;
        // TODO needs implementation (Assignment 3a)
    }

    @Override
    public void sort(@NotNull Comparator<? super E> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This operation is not yet implemented!");
        // TODO needs implementation (Assignment 3b)
    }

    /**
     * Creates a new array of type <code>E</code> with the given size.
     *
     * @param length the size of the array
     * @return a new array of type <code>E</code> and the given length
     */
    private E[] createEmptyArray(int length) {
        // there is unfortunately no really easy and elegant way to initialize
        // an array with a type coming in as a generic type parameter, but
        // the following is simple enough. And it is OK, since the array
        // is never passed out of this class.
        return (E[]) new Object[length];
    }

    // TODO probably some private helper methods here (avoiding duplicated code)
    //      (Assignment 3a)
    private void doubleList() {
        E[] newArray = (E[]) new Object[size*2];
        System.arraycopy(list, 0, newArray, 0, size);
        list = newArray;
    }

    private void halveList() {
        if (size >= DEFAULT_SIZE) {
            E[] newArray = (E[]) new Object[list.length / 2];
            System.arraycopy(list, 0, newArray, 0, size);
            list = newArray
        }
    }

    private void shiftUp(int pos) {
        // Assuming size has been handled
        int temp = list[pos];
        list[pos] = null;
        for (int i = pos+1; i<size+1; i++) {
            // swap temp and list[i] using b = a + b - (a = b);
            list[i] = temp + list[i] - (temp = list[i]);
        }
        size++;
    }

    private void shiftDown(int pos) {
        // Assuming size has been handled
        int temp = list[size-1];
        list[size-1] = null;
        for (int i = size-2; i>pos-1; i--) {
            // swap temp and list[i] using b = a + b - (a = b);
            list[i] = temp + list[i] - (temp = list[i]);
        }
        size--;
    }

}
