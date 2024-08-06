package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

public class DoublyLinkedListImplementation <T>{

    /*
    Each Doubly linked list has two parts:
    1) A Node with two pointers that represents the head of the LinkedList.
    2) A Node with two pointers that represents the tail of the LinkedList.
     */
    private DoublyNode<T> head;
    private DoublyNode<T> tail;


    /*
    Constructor 01: This constructor is used to create a Doubly LikedList from scratch.
     */
    public DoublyLinkedListImplementation() {
        this.head = null;
        this.tail = null;
    }



}
