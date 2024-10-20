package co.edu.unbosque.model.dsa.nonLineal.interfaces;

public interface IHeap <T extends Comparable<T>>{


    IHeap<T> insert(T data);
    T getRoot();
    void sort();

}
