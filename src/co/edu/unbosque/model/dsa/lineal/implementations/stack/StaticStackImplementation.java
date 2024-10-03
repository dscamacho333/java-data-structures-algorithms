package co.edu.unbosque.model.dsa.lineal.implementations.stack;

import co.edu.unbosque.model.dsa.lineal.interfaces.IStack;

public class StaticStackImplementation <T> implements IStack<T> {

    /*
     Every Static Stack must have two attributes:
     1) StackArray (Array): Represents the static stack.
     2) Top (int): Represents the top position of the stack.
     */
    private T stackArray[];
    private int top;

    /*
    Constructor: This one is used to create a static stack from zero and indicate the size of it.
     */
    public StaticStackImplementation(int size){
        stackArray = (T[]) new Object[size];
        top = -1;
    }

    /*
    Method to add an element to the Stack:
    1) Increment the top value.
    2) Assign the value to the StackArray at the top position.
     */
    @Override
    public void push(T value) {
        top++;
        stackArray[top] = value;
    }

    /*
    Method to delete an element from the Stack:
    1) Create an aux variable to assign the top value to it.
    2) Assign a null value to the position of the element that was popped.
    2) Decrement the top value.
    3) Return the aux variable with the Top value.
     */
    @Override
    public T pop() {
        T pop =  stackArray[top];
        stackArray[top] = null;
        top--;
        return pop;
    }

    /*
    Method to validate if the Stack is empty:
    1) Return if the variable top equals -1.
     */
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    /*
    Method to validate if the Stack is full:
    1) Return if the StackArray length -1 equals the top variable.
     */
    @Override
    public boolean isFull() {
        return ((stackArray.length - 1) == top);
    }

    /*
    Method to get the top value of the Stack:
    1) Return the value at the last position of the StackArray.
     */
    @Override
    public T getTop() {
        return (stackArray[top]);
    }

    /*
    Method to get the Stack Length:
    1) Return the StackArray length through the build-in method.
     */
    @Override
    public int getStackLength() {
        return (stackArray.length);
    }

    /*
     Method to clear the Stack:
     1) Get the size of the existing stack through the method getStackLength().
     2) Assign a new array to the stackArray attribute.
     3) Reset top to the default value (-1).
     */
    @Override
    public void clearStack() {
       int size = getStackLength();
       stackArray = (T[]) new Object[size];
       top = -1;
    }

    /*
     Method to read the Stack:
     1) Iterate with a foreach loop through every value.
     2) Print  every value.
     */
    @Override
    public void readStack() {
        for(T aux: stackArray){
            System.out.println("Value: " + aux);
        }
    }


}
