package co.edu.unbosque.model.dsa.lineal.implementations.queue;

public class QueueNode <T>{

    /*
    Every Queue Node has two attributes:
    1) Value.
    2) Queue Node pointing to the next Node.
     */
    T value;
    QueueNode<T> next;

    /*
    Constructor: This one is used when it is required to create a new Queue Node from zero.
     */
    public QueueNode(T value){
        this.value = value;
        this.next = null;
    }

}
