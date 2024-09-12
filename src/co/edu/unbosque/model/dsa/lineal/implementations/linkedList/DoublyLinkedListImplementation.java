package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

import co.edu.unbosque.model.dsa.lineal.interfaces.IDoublyLinkedList;

public class DoublyLinkedListImplementation <T> implements IDoublyLinkedList<T> {

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

    /*
    Verifies if the DoublyLinkedList is empty or not:
    1) Evaluates whether the Doubly Node "head" is pointing to Null
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /*
    Create a Node to the end of the DoublyLinkedList:
    1) Evaluates if the DoublyLinkedList is not empty (!isEmpty()).
    a) If TRUE:
    2) Point Tail Node to a new Doubly Node with the given value, next pointing to Null and previous pointing to Tail.
    3) Point previous node of the next Node of the Tail to the Tail.
    b) If FALSE:
    4) Point head to a new Doubly Node with the given value only.
    5) Point the tail to the head.
     */
    @Override
    public void createToTail(T value) {
        if(!(isEmpty())){
             tail = new DoublyNode<>(value, null, tail);
             tail.previous.next = tail;
        }else{
             head = new DoublyNode<>(value);
             tail = head;
        }
    }

    /*
    Create a Node at the head of the DoublyLinkedList:
    1) Evaluates if the DoublyLinkedList is not empty. (!isEmpty())
    a) If TRUE:
    2) Point the Head Node to a new Node with the given value, next pointing to the previous Head Node and previous pointing to Null.
    3) Point the Head of next of previous to the Head.
    b) If FALSE:
    4) Point the Head Node to a new Doubly Node with the given value.
    5) Point the Tail Node to the Head Node.
     */
    @Override
    public void createToHead(T value) {
        if(!(isEmpty())){
            head = new DoublyNode<>(value, head, null);
            head.next.previous = head;
        }else{
            head = new DoublyNode<>(value);
            tail = head;
        }
    }

    /*
    Delete a Node from the Head of the DoublyLinkedList:
    1) Evaluate if Head Node is equal to Tail Node. (There is only one Node)
    a) If TRUE:
    2) Point Head Node to Null.
    3) Point Tail Node to Null.
    b) If FAlSE:
    4) Point Head Node to the next Node.
    5) Point the previous Node to Head Node to Null.
     */
    @Override
    public void deleteFromHead() {
        if( head == tail ){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.previous = null;
        }
    }

    /*
    Delete a Node from the Tail of the doublyLinkedList:
    1) Evaluate if the Head Node is equal to the Tail Node.
    a) If TRUE:
    2) Point Head Node to Null.
    3) Point Tail Node to Null.
    b) If FALSE:
    4) Point Tail Node to the previous Node.
    5) Point Next Node of Tail to Null.
     */
    @Override
    public void deleteFromTail() {
        if( head == tail ){
            head = null;
            tail = null;
        }else{
            tail = tail.previous;
            tail.next = null;
        }
    }

    /*
    Read every Node value from Head Node to Tail Node:
    1) Evaluates if the DoublyLinkedList is not empty. (!isEmpty())
    a) If TRUE:
    1) Create a temporary Doubly Node and point it to the List head.
    2) Iterate with a While Loop evaluating if the temporary Node is different to Null.
    3) Print the Node value on console.
    4) Point temp Node to the next Node.
    b) If FALSE:
    5) Print a message saying the DoublyLinkedList is empty.
     */
    @Override
    public void readFromHeadToTail() {
        if(!(isEmpty())){
            DoublyNode temp = head;
            while(temp != null){
                System.out.print("<-------->" + "[Node:" + temp.value + "]" + "<-------->");
                temp = temp.next;
            }
        }else{
            System.out.println("The DoublyLinkedList is empty!");
        }
    }

    /*
    Read every Node value from Tail Node to head Node:
    1) Evaluates if the DoublyLinkedList is not empty. (!isEmpty())
    a) If TRUE:
    1) Create a temporary Doubly Node and point it to the List Tail.
    2) Iterate with a While Loop evaluating if the temporary Node is different to Null.
    3) Print the Node value on console.
    4) Point temp Node to the previous Node.
    b) If FALSE:
    5) Print a message saying the DoublyLinkedList is empty.
     */
    @Override
    public void readFromTailToHead() {
        if(!(isEmpty())){
            DoublyNode temp = tail;
            while(temp != null){
                System.out.print("<-------->" + "[Node:" + temp.value + "]" + "<-------->");
                temp = temp.previous;
            }
        }else{
            System.out.println("The DoublyLinkedList is empty!");
        }
    }
}
