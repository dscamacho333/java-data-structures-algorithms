package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface IStack <T> {

    void push(T value);
    T pop();
    boolean isEmpty();
    boolean isFull();
    T getTop();
    int getStackLength();
    void clearStack();
    void readStack();
}
