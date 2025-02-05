package dk.dtu.compute.course02324.assignment1.integerstack.implementations;

import dk.dtu.compute.course02324.assignment1.integerstack.types.Stack;

/**
 * Implements a {@link Stack} of integers as a (singly) linked list.
 * TODO note that this is template only, and the actual functions of
 *      the stack are not implemented yet. Impelemnting these methods
 *      is the task of assignment 1.
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 */
public class LinkedListStack implements Stack {

    private StackElement top = null;

    private int size = 0;

    @Override
    public void clear() {
        // TODO must be implemented
    }

    @Override
    public Integer pop() {

        return 0;
    }

    @Override
    public Integer top() {
        // TODO must be implemented
        return 0;
    }

    @Override
    public void push(Integer value) {
        // TODO must be implemented
    }

    @Override
    public int size() {
        // TODO must be implemented
        return -1;
    }


    /**
     * Represents a single element on the linked list stack with its
     * value and a pointer to the next element.
     *
     * @author Ekkart Kindler, ekki@dtu.dk
     */
    private class StackElement {

        private Integer value;

        private StackElement next;

        private StackElement(Integer value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

}
