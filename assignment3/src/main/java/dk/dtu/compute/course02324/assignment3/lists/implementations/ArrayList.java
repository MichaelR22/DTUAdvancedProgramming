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
        if (pos>=size || pos<0) {
            throw new IndexOutOfBoundsException("Not within bounds");
        }
        return list[pos];
    }

    @Override
    public E set(int pos, @NotNull E e) throws IndexOutOfBoundsException {
        if (pos>size || pos<0) {
            throw new IndexOutOfBoundsException("Not within bounds");
        }
        E ele = list[pos];
        list[pos] = e;
        return ele;
    }

    @Override
    public boolean add(@NotNull E e) {
        if (e == null) {throw new IllegalArgumentException("Can't add null element");}
        if (size==list.length){ doubleList();}
        list[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean add(int pos, @NotNull E e) throws IndexOutOfBoundsException {
        if (e == null) {throw new IllegalArgumentException("Can't add null element");}
        if ((pos>size && size>0) || pos<0) {throw new IndexOutOfBoundsException("Not within bounds");}
        if (size==list.length){ doubleList();}
        shiftUp(pos);
        list[pos] = e;
        return true;
    }

    @Override
    public E remove(int pos) throws IndexOutOfBoundsException {
        if (pos>=size || pos<0) {throw new IndexOutOfBoundsException("Not within bounds");}
        E ele = list[pos];
        shiftDown(pos);
        if (size < list.length/2) { halveList();}
        return ele;
    }

    @Override
    public boolean remove(E e) {
        if (indexOf(e) != -1) {
            remove(indexOf(e));
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i<size; i++) {
            if (e.equals(list[i])) {    // bloody hell java
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort(@NotNull Comparator<? super E> c) throws UnsupportedOperationException {
        if (c == null) {throw new IllegalArgumentException("comparator cannot be null");}
        boolean swapped;
        int j = size;
        do {
            swapped = false;
            for (int i = 0; i+1<j; i++) {
                if (c.compare(list[i], list[i + 1]) > 0) {
                    list[i] = returnFirst(list[i + 1], list[i + 1] = list[i]);
                    swapped = true;
                }
            }
            j--;
        } while (swapped);

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

    private void doubleList() {
        E[] newArray = (E[]) new Object[size*2];
        System.arraycopy(list, 0, newArray, 0, size);
        list = newArray;
    }

    private void halveList() {
        if (size >= DEFAULT_SIZE) {
            E[] newArray = (E[]) new Object[list.length / 2];
            System.arraycopy(list, 0, newArray, 0, size);
            list = newArray;
        }
    }

    private E returnFirst(E x, E y) {
        //use to swap x,y as returnFirst(x, x = y)
        return x;
    }

    /**
     * Handles changing <code>size</code>
     */
    private void shiftUp(int pos) {
        // Assuming size has been handled
        E temp = list[pos];
        list[pos] = null;
        for (int i = pos+1; i<size+1; i++) {
            list[i] = returnFirst(temp, temp=list[i]);
        }
        size++;
    }

    /**
     * Handles changing <code>size</code>
     */
    private void shiftDown(int pos) {
        // Assuming size has been handled
        E temp = list[size-1];
        list[size-1] = null;
        for (int i = size-2; i>=pos; i--) {
            // swap temp and list[i] using b = a + b - (a = b);
            list[i] = returnFirst(temp, temp=list[i]);
        }
        size--;
    }

}
