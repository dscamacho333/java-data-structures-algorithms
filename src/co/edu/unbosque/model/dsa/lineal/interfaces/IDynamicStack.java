package co.edu.unbosque.model.dsa.lineal.interfaces;

public interface IDynamicStack <T>{

    void push(T value);
    T pop();
    boolean isEmpty();
    T getTop();
    int getStackLength();
    void clearStack();

}
