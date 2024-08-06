package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

import co.edu.unbosque.model.dsa.lineal.interfaces.ILinkedList;

public class LinkedListImplementation <T> implements ILinkedList<T> {

    /*
    Each list has two main parts:
    1) Head: This is a pointer to the first node of the LinkedList.
    2) Tail: This is a pointer to the last node of the LinkedList.
    Note: Handling a list is basically playing with the pointers.
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
    Search for specific Node which contains the value algorithm:
    1) We create a temporary Node (temp).
    2) We point temporary Node to the head.
    3) Iterate the list to move forward as long as the temp Node is different to Null and the value is not found yet.
    4) Return the condition: Is not the temporary Node empty?
    If true:
    4.1) It means that after moving through all the list the element was found.
    If false:
    4.2) It means that after moving through all the list no element with the valued looked up was found.
     */
    @Override
    public boolean contains(T value) {
        Node<T> temp;
        temp = head;
        while((temp != null) && !(temp.value.equals(value))){
            temp= temp.next;
        }
        return temp != null;
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

    /*
    Delete any Node from LinkedList algorithm:
    1) Validate if the list is not empty.
    If true:
    2) Validate if there is only one element, and it contains the value to be deleted.
    If true:
    3) We point the head to Null.
    4) We point the tail to Null.
    Else if ( (5) Validate if the first elements is the value we are looking and there are at least two elements):
    6) We point the head to the next element to the head to delete it.
    If false:
    7) We create a Node called prev which represents the previous Node.
    8) We create a Node called temp which represent a temporary Node.
    9) We point Node prev to the head.
    10) We point Node temp to the Node after head.
    11  We start iterating the LinkedList to move through it as long as temporary Node is different to Null and temporary Node value is different to the value to be found.
    12) Validate if temporary Node is different to Null.
    If true:
    13) We point next Node of prev Node to next Node of temp Node.
    14) Validate if the temp Node equals the tail Node.
    If true:
    15) We point previous Node to the tail.
     */
    @Override
    public void deleteSpecificNode(T value) {
        if(!isEmpty()){
            if((head == tail) && (value.equals(head.value))){
                head = null;
                tail = null;
            }else if(value.equals(head.value)){
                head = head.next;
            }else{
                Node<T> prev;
                Node<T> temp;
                prev = head;
                temp = head.next;
                while((temp != null) && !(temp.value.equals(value))){
                    prev = prev.next;
                    temp = temp.next;
                }
                if(temp != null){
                    prev.next = temp.next;
                    if(temp == tail){
                        tail = prev;
                    }
                }
            }
        }
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
