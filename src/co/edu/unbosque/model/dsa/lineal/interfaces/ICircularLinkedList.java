package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface ICircularLinkedList <T>{

    boolean isEmpty();
    void createCircularNode(T value);
    boolean deleteNode(T value);
    void readAllNodes();

}
