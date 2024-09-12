package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

public class DoublyNode <T>{

    /*
    Each Doubly Node has three parts:
    1) Value
    2) Node pointing to the next Node.
    3) Node pointing to the previous Node.
     */
    public T value;
    public DoublyNode <T> next;
    public DoublyNode <T> previous;

    /*
    Constructor 01: This constructor is used when there are already existing Nodes.
     */
    public DoublyNode (T value, DoublyNode <T> next, DoublyNode <T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    /*
    Constructor 02: This constructor is used when there are not existing Nodes.
     */
    public DoublyNode (T value) {
        this(value, null, null); //Note: This is a way to call an existing Constructor.
    }


}
