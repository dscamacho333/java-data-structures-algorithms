package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface ILinkedList <T> {

    void createToHead(T value);
    void createToTail(T value);
    boolean isEmpty();
    void deleteFromHead();
    void deleteFromTail();
    void deleteSpecificNode(T value);
    void readAll();


}
