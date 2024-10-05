package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface IQueue <T>{

    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
    T getQueueHead();
    int getQueueLength();
    void readQueueNodes();


}
