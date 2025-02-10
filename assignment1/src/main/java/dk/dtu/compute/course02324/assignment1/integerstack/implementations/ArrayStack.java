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
        if (size!=array.length){
            array[size] = value;
            size++;
        }
        Integer[] newArray = new Integer[size*2];
        for (int i = 0; i < size ; i++){
            newArray[i] = array[i];
        }
        // System.arraycopy(array, 0, newArray, 0, size);
        newArray[size] = value;
        array = newArray;
    }

    @Override
    public int size() {
        // TODO must be implemented
        return size;
    }

}
