package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface IDoublyLinkedList <T>{

    boolean isEmpty();
    void createToTail(T value);
    void createToHead(T value);
    void deleteFromHead();
    void deleteFromTail();
    void readFromHeadToTail();
    void readFromTailToHead();


}
