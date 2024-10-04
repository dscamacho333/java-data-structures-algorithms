package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface IStaticStack<T> {

    void push(T value);
    T pop();
    boolean isEmpty();
    boolean isFull();
    T getTop();
    int getStackLength();
    void clearStack();
    void readStack();
}
