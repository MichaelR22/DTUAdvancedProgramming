package dk.dtu.compute.course02324.assignment2.genericstack.implementations;

import dk.dtu.compute.course02324.assignment2.genericstack.types.Stack;

import javax.validation.constraints.NotNull;

/**
 * Implements a generic {@link Stack} as a (singly) linked list of
 * elements of generic type <code>E</code>.
 *
 * @param <E> the type of the values/elements on the stack
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 *
 */
public class LinkedListStack<E> implements Stack<E> {

    private StackElement<E> top = null;

    private int size = 0;

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public E pop() throws IllegalStateException {
        // TODO must be implemented
        if (top != null) {
            E element = top.value;
            top = top.next;
            size--;
            return element;
        }
        throw new IllegalStateException(
                "Cannot pop from empty stack"
        );
    }

    @Override
    public E top() throws IllegalStateException {
        // TODO must be implemented
        if (top != null){
            return top.value;
        }
        throw new IllegalStateException(
                "Cannot check top on an empty stack"
        );
    }

    @Override
    public void push(@NotNull E value) throws IllegalArgumentException {
        // TODO must be implemented
        top = new StackElement<E>(value, top);
        size++;
    }

    @Override
    public int size() {
        // TODO must be implemented
        return size;
    }

    /**
     * Represents a single element on the linked list stack with its
     * value and a pointer to the next element.
     *
     * @param <EE> the type of the values on the stack
     *
     * @author Ekkart Kindler, ekki@dtu.dk
     */
    private class StackElement<EE> {

        final private EE value;

        final private StackElement<EE> next;

        /**
         * Creates a new StackElement from a value and a (potentially
         * <code>null</code>) pointer to the <code>next</code> StackElement.
         *
         * @param value the value of the element
         * @param next the pointer to the next element on the stack
         * @throws IllegalArgumentException if the provided value is <code>null</code>
         */
        private StackElement(@NotNull EE value, StackElement<EE> next) throws IllegalArgumentException {
            // Note that the javax @NotNull annotation by itself does not "do" anything;
            // so we explicitly check the value for null here and in that case throw an exception.
            //
            // NB: Some other assertion annotations (e.g. from Lombok or jetbrains modules)
            //     do throw (under certain running conditions) exceptions when the assertion fails!
            if (value == null) {
                throw new IllegalArgumentException(
                        "Value argument of StackElement should not be null");
            }

            this.value = value;
            this.next = next;
        }
    }

}
