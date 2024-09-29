package co.edu.unbosque.model.dsa.lineal.implementations.linkedList;

import co.edu.unbosque.model.dsa.lineal.interfaces.ICircularLinkedList;

public class CircularLinkedListImplementation <T> implements ICircularLinkedList <T> {

    /*
    Every CircularLinkedList has one attribute:
    1) A Node that points to the last Node of the CircularLinkedList as reference.
     */
    private CircularNode<T> last;

    /*
     Constructor: This constructor is used every time a new CircularLinkedListImplementation object is required.
     */
    public CircularLinkedListImplementation() {
        this.last = null;
    }

    /*
     Verifies whether the CircularLinkedList is empty or not:
    1) Evaluates if the Circular Node "Last" is pointing to Null.
     */
    @Override
    public boolean isEmpty() {
        return (this.last == null);
    }

    /*
    Method to create a new Node:
    1) Create a new Circular Node and assign a value to it.
    2) Validate if last Node is Null.
    A) If TRUE
    3) Assign the new Node to the last Node.
    B) If FALSE
    4) Assign next node of the last Node to the next Node of new Node.
    5) Assign new Node to the next Node of last Node.
     */
    @Override
    public void createCircularNode(T value) {

        CircularNode<T> circularNode = new CircularNode<>(value);
        if(last == null) {
            last = circularNode;
        }else{
            circularNode.next = last.next;
            last.next = circularNode;
        }
    }

    /*

     */
    @Override
    public void deleteNode(T value) {
    }


    /*
    Method to read every Node within the CircularLinkedList:
    1) Create an auxiliary Node pointing to the last Node.
    2) Verify if aux Node is different to the last Node on a While loop.
    A) If TRUE
    3) Print the Node value.
    4) Point aux to the next Node to keep iterating.
    B) If FALSE
    5) Exit the While loop.
     */
    @Override
    public void readAllNodes() {

        CircularNode<T> aux = last;
        while(aux != last) {
            System.out.print("[Node value: " + aux.value + "] ----->");
            aux = aux.next;
        }
    }


}
