package co.edu.unbosque.model.dsa.lineal.implementations.stack;

public class StackNode <T> {

    /*
    Every Stack Node has two attributes:
    1) Value.
    2) Pointer to the next Node.
     */
    T value;
    StackNode<T> next;

    /*
    Constructor: This one is used to create a Stack Node from zero.
     */
    public StackNode(T value){
        this.value = value;
        this.next = null;
    }


}
