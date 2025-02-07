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
	private int topValue;


	@Override
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}

	@Override
	public Integer pop() {
		if (array[array.length-1] != null) {
			topValue = array[array.length-1];
			for (int i = array.length; i > 1; i--) {
				array[i-1] = array[i-2];
			}
			array[0] = null;
			size--;
			return topValue;
			
		}
		else {
			return null;
		}
	}

	@Override
	public Integer top() {
		if (array[array.length-1] != null) {
			return topValue = array[array.length-1];
		}
		else {
			return null;
		}
	}
	
	private void ExpandArray(Integer[] array) {
		Integer[] exArray = new Integer[array.length+5];
		for (int i = 0; i < array.length; i++) {
			exArray[i+4] = array[i];
		}
		array = exArray;
	}

	@Override
	public void push(Integer value) {
		if (array[0] != null) {
			ExpandArray(array);
		}
		for (int i = 0; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
		size++;
		array[array.length-1] = value;
	}

	@Override
	public int size() {
		//size = array.length;
		return size;
		//return 0 clears the test?
	}

}
