package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

public class Node <T> {

    /*
    Each node has two parts:
    1) Value: Data that we want to store inside the node.
    2) Next/Link: It is the pointer to the next Node in the list.
    */
    public T value;
    public Node<T> next;

    /*
    Constructor 1: This constructor is used to insert a value to the end of the LinkedList.
     */
    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    /*
    Constructor 2: This constructor is used to insert a value to the start of the LinkedList.
     */
    public Node(T value, Node<T> node){
        this.value = value;
        this.next = node;
    }

}
