package dk.dtu.compute.course02324.assignment1.integerstack.implementations;

import dk.dtu.compute.course02324.assignment1.integerstack.types.Stack;
import java.util.Arrays;
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
		for(int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}

	@Override
	public Integer pop() {
		if (size == 0) return null;
		Integer topValue1 = array[size - 1];
		array[size - 1] = null;
		size--;
		return topValue1;
	}

	@Override
	public Integer top() {
		if (size == 0) {
			return null;
		} else {
			return array[size - 1];
		}
	}

	@Override
	public void push(Integer value) {
		if (size == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[size++] = value;
	}

	@Override
	public int size() {
		return size;
	}
}
