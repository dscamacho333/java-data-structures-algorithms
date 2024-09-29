package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

public class CircularNode <T> {

    /*
    Every Circular Node has two attributes:
    1) Value
    2) Node pointing to the next Node
     */
    T value;
    CircularNode<T> next;

    /*
    Constructor: This constructor is always used to create a Circular Node.
     */
    public CircularNode(T value) {
        this.value = value;
        this.next = this;
    }

}
