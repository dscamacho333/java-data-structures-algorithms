package co.edu.unbosque.model.dsa.lineal.implementations.queue;

import co.edu.unbosque.model.dsa.lineal.interfaces.IQueue;

public class QueueImplementation <T> implements IQueue<T> {

    /*
    Every Queue has three attributes:
    1) Head Node, representing the Queue first Node.
    2) Tail Node, representing the Queue last Node.
    3) Length, representing the Queue length.
     */
    private QueueNode<T> head;
    private QueueNode<T> tail;
    private int length;

    /*
    Constructor: This one is used when it is required to create a Queue from zero.
     */
    public QueueImplementation(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /*
    Method to add an element to the Queue:
    1) Create a new Node with the value provided.
    2) Validate if the Queue is empty.
    A) If TRUE
    3) Point the new Node to the Head Node.
    B) If FALSE
    4) Point new Node to the next Node of Tail Node
    C) BOTH CASES
    5) Point new Node as the Tail Node.
    6) Increment the length attribute by one.
     */
    @Override
    public void enqueue(T value) {
        QueueNode<T> newNode = new QueueNode<>(value);
        if((isEmpty())){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    /*
    Method to delete an element from the Queue:
    1) Assign head Node value to an aux variable.
    2) Assign head to the next Node of the current Head.
    3) Decrement the length by one.
    4) Return aux variable containing the value.
     */
    @Override
    public T dequeue() {
        T aux = head.value;
        head = head.next;
        length--;
        return aux;
    }

    /*
    Method to validate if the Queue is empty:
    1) Return if Head Node is Null.
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /*
    Method to get the Queue Head element:
    1) Return the Head Node Value.
     */
    @Override
    public T getQueueHead() {
        return (head.value);
    }

    /*
    Method to get the Queue length:
    1) Return the length value.
     */
    @Override
    public int getQueueLength() {
        return (length);
    }

    /*
    Method to read the Queue:
    1) Create a local variable representing the position and initialize it on 1.
    2) Create an auxiliary local variable to move Node by Node.
    3) Iterate while aux variable is not null.
    4) Print the Aux Node Value.
    5) Move to the next Node.
    6) Increment the position.
     */
    @Override
    public void readQueueNodes() {
        int position = 1;
        QueueNode<T> aux = head;
        while(aux != null){
            System.out.print("Node #" + position + ": " + aux.value);
            aux = aux.next;
            position++;
        }
    }
}
