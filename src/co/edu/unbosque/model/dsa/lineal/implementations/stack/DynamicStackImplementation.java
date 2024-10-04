package co.edu.unbosque.model.dsa.lineal.implementations.stack;


import co.edu.unbosque.model.dsa.lineal.interfaces.IDynamicStack;

public class DynamicStackImplementation <T> implements IDynamicStack<T> {

    /*
    Every Dynamic Stack has two attributes:
    1) Stack Node representing the top of the Stack.
    2) Length representing the length of the Stack.
     */
    private StackNode<T> top;
    private int length;

    /*
    Constructor: This one is used to create a Dynamic Stack from zero.
     */
    public DynamicStackImplementation(){
        this.top = null;
        this.length = 0;
    }

    /*
    Method to add an element into the Stack:
    1) Create a new Stack Node and assign the value provided.
    2) Point the next node of new node to the top Node.
    3) Point new Node to Top Node.
    4) Increment the length by one.
     */
    @Override
    public void push(T value) {
        StackNode<T> newNode = new StackNode<>(value);
        newNode.next = top;
        top = newNode;
        length++;
    }

    /*
    Method to delete an element from the Dynamic Stack:
    1) Assign the Top Node Value to an aux variable.
    2) Assign Next Node of Top Node as the new Top Node.
    3) Decrement the length by one.
    4) Return aux variable with the Value.
     */
    @Override
    public T pop() {
        T aux = top.value;
        top = top.next;
        length--;
        return aux;
    }

    /*
    Method to validate if Dynamic Stack is empty:
    1) Return if top equals to Null.
     */
    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    /*
    Method to get the top value from the Dynamic Stack:
    1) Return the Top Node Value.
     */
    @Override
    public T getTop() {
        return (top.value);
    }

    /*
    Method to get the Dynamic Stack Length:
    1) Return the Length variable.
     */
    @Override
    public int getStackLength() {
        return (length);
    }

    /*
    Method to clear the Dynamic Stack:
    1) Iterate through every Stack Node
    2) Pop every Node as it iterates.
     */
    @Override
    public void clearStack() {
        while(!(isEmpty())){
            pop();
        }
    }

}
