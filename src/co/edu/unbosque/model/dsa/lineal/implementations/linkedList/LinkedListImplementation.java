package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

import co.edu.unbosque.model.dsa.lineal.interfaces.ILinkedList;

public class LinkedListImplementation <T> implements ILinkedList<T> {

    /*
    Each list has two main parts:
    1) Head: This is a pointer to the first node of the LinkedList.
    2) Tail: This is a pointer to the last node of the LinkedList.
     */
    protected Node<T> head;
    protected Node<T> tail;

    /*
    Constructor 1: This constructor is used to create a LinkedList from scratch.
     */
    public LinkedListImplementation() {
        head = null;
        tail = null;
    }

    /*
    Create a node to the head algorithm:
    1) We create a Node and pointing the head to it.
    2) We verify if the tail is null: If tail is null it means there was not neither a head nor a tail before.
    2.1) We point the tail to the head since there is only one element in the LinkedList.
    2.2) We keep the tail pointing to the same place.
     */
    @Override
    public void createToHead(T value) {
        head = new Node<>(value, head);
        if(tail == null){
            tail = head;
        }
    }

    /*
    Create a node to the tail algorithm:
    1) Verify if LinkedList is not empty.
    If true:
    2) We create a new Node with a value and assign the Node ahead of the tail (Last element).
    3) We point the tail to the element after the tail (new tail).
    If false:
    4) We create a new Node and assign it to the head. (First element).
    5) We point the tail to the head since there is only one element.
     */
    @Override
    public void createToTail(T value) {
        if(!isEmpty()){
            tail.next = new Node<>(value);
            tail = tail.next;
        }else{
            head = new Node<>(value);
            tail = head;
        }
    }

    /*
    Verifies if the LinkedList is empty or not:
    1) Validates if head does not point to Null
    1.1) If true: LinkedList is not empty .
    1.2) If false: LinkedList is empty.
     */
    @Override
    public boolean isEmpty() {
        if(head != null){
            return false;
        }else{
            return true;
        }
    }

    /*
    Delete a node from the head of the LinkedList algorithm:
    1) Validate if the head is not equal to the tail. (It means there is only one element)
    If true:
    2) We point the head to the next Node of the head.
    If false:
    3) We point the head to Null.
    4) We point the tail to Null.
     */
    @Override
    public void deleteFromHead() {
        if(!(head == tail)){
           head = head.next;
        }else{
            head = null;
            tail = null;
        }
    }

    /*
    Delete a node from the tail of the LinkedList algorithm:
    1)  Validate if the head is not equal to the tail. (It means there is only one element)
    If true:
    2) We point the head to the next Node of the head.
    If false:
    3) Create a temporary Node.
    4) Iterate the Node to move forward on the LinkedList while it is different from the tail.
    5) Once the temporary has reached the tail, we point the temporary Node to the tail.
    6) We point the next Node (previous tail and element to be deleted) to Null.
     */
    @Override
    public void deleteFromTail() {
        if(!(head == tail)){
            Node<T> temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }else{
            head = null;
            tail = null;
        }
    }

    @Override
    public void deleteSpecificNode(T value) {
        
    }

    /*
    Read all the values within the LinkedList algorithm:
    1) We create a temporary node which starts at the head of the list.
    2) We iterate to move to every node and show its value while the node is not null.
     */
    @Override
    public void readAll() {
       Node<T> temp = head;
       while(temp != null){
           System.out.print("[Node:" + temp.value +"] ---->");
           temp = temp.next;
       }
    }
}
